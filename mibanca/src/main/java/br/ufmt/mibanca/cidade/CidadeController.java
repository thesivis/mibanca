package br.ufmt.mibanca.cidade;

import java.util.List;
import java.util.Optional;

//import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/cidade")
@RequiredArgsConstructor

public class CidadeController {

    private final CidadeRepository repository;

    @GetMapping(path = "/")
    public List<Cidade> index() {
        return repository.findAll();
    }

    @GetMapping
    public ResponseEntity<Cidade> getById(@PathVariable(name = "id") int id) {
        Optional<Cidade> found = repository.findById(id);
        if(found.isPresent()){
            return ResponseEntity.ok().body(found.get());
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping(path = "/{pk}")
    public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id){
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException erro) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody Cidade request){
        Cidade cidade = new Cidade();

        cidade.setNome(request.getNome());
        cidade.setCodPostal(request.getCodPostal());

        try {
            repository.save(cidade);
        } catch(IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados enválidos!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody CidadeRequest request){
        Cidade cidade = new Cidade();

        cidade.setId(id);
        cidade.setNome(request.getNome());
        cidade.setCodPostal(request.getCodPostal());

        try{
            repository.save(cidade);
        } catch(IllegalArgumentException error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    // @GetMapping(path = "/teste")
    // @Transactional
    // public boolean dadoTeste() {
        
    //     Cidade cidade = new Cidade();
    //     cidade.setNome("Cuiabá");
        
    //     repository.save(cidade);
    //     return true; 
    // }

}