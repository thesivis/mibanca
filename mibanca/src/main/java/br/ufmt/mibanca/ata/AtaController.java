package br.ufmt.mibanca.ata;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufmt.mibanca.tipoata.TipoAta;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/ata")
@RequiredArgsConstructor
public class AtaController {
    
    private final AtaRepository repository;

    @GetMapping(path = "/")
    public List<Ata> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AtaResponse> getById(@PathVariable(name="id") int id){
        Optional<Ata> found = repository.findById(id);
        if (found.isPresent()) {
            AtaResponse response = AtaResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity remover(@PathVariable(name="id") int id){
        try{
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch(EmptyResultDataAccessException erro){
            return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping(path = "/")
    public ResponseEntity cadastra(@RequestBody AtaResquest ataResquest){
        Ata ata = AtaResquest.from(ataResquest);
        try{
            repository.save(ata);

        }catch (IllegalArgumentException error){
            return ResponseEntity.badRequest().body("null");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualiza(@PathVariable int id, @RequestBody AtaResquest request){
        Ata ata = new Ata();
        ata.setId(id);
        ata.setTextoAta(request.getTextoAta());
        try{
            repository.save(ata);
        }catch(IllegalArgumentException error){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    
}
