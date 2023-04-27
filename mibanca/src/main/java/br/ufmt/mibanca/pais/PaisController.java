package br.ufmt.mibanca.pais;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transaction;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/pais")
@RequiredArgsConstructor
public class PaisController {
   
    private final PaisRepository repository;

    @GetMapping(path = "/")
    public List<Pais> index() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PaisResponse> getById(@PathVariable(name = "id") int id) {
        Optional<Pais> found = repository.findById(id);
        if(found.isPresent()) {
            PaisResponse response = PaisResponse.from(found.get());
            return ResponseEntity.ok().body(response);
    }
        return ResponseEntity.notFound().build();
}    
    @DeleteMapping(path = "/(id)")
    public ResponseEntity<PaisResponse> remover(@PathVariable int id){
        try {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }   catch(EmptyResultDataAccessException erro)    {
        return ResponseEntity.notFound().build();
}


}
}
