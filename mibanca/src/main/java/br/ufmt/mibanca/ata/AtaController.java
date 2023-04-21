package br.ufmt.mibanca.ata;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Ata cadastra(@RequestBody AtaResquest ataResquest){
        Ata ata = AtaResquest.from(ataResquest);
        repository.save(ata);
        return ata;
    }
    
}
