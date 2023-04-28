package br.ufmt.mibanca.tipoMembro;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="/tipomembro")
@RequiredArgsConstructor
public class TipoMembroController {
    
    private final TipoMembroRepository repository;

    @GetMapping(path="/")
    public List<TipoMembro> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TipoMembroResponse> getById(@PathVariable int id){
        Optional<TipoMembro> found = repository.findById(id);

        if(found.isPresent()){
            TipoMembroResponse response = TipoMembroResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{pk}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "pk") int id){
        try{
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch(EmptyResultDataAccessException erro){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody TipoMembroRequest request){        
        TipoMembro dados = TipoMembroRequest.transcribe(request);

        try {
        repository.save(dados);
        } catch(IllegalArgumentException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id,
                                            @RequestBody TipoMembroRequest request){
        TipoMembro tipoMembro = TipoMembroRequest.transcribe(request);
        tipoMembro.setId(id);

        try{
            repository.save(tipoMembro);
        } catch(IllegalArgumentException e){
            e.printStackTrace();
            ResponseEntity.badRequest().body("Dados inválidos!");
        }
        return ResponseEntity.ok().build();
    }
}
