package br.ufmt.mibanca.tipoMembro;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<TipoMembro> adicionar(@RequestBody TipoMembroRequest dados){
        TipoMembro request = TipoMembroRequest.to(dados);
        repository.save(request);
        return ResponseEntity.ok().body(request);
    }
}
