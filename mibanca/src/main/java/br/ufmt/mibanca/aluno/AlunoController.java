package br.ufmt.mibanca.aluno;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/aluno")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoRepository repository;

    @GetMapping(path = "/")
    public List<Aluno> index() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AlunoResponse> getById(@PathVariable int id){
     Optional<Aluno> found = repository.findById(id);
     if(found.isPresent()){
        AlunoResponse response = AlunoResponse.from(found.get());
        return ResponseEntity.ok().body(response);
     }
     return ResponseEntity.notFound().build();
    }

    @DeleteMapping (path = "/{pk}")
    public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id){
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();   
        } catch (EmptyResultDataAccessException erro) {
           return ResponseEntity.notFound().build();
           // TODO: handle exception
        }
    }
     
   /*  @PostMapping (path = "/create")
    public RequestEntity<Aluno> add(@PathVariable(name = "create")){

    }
    Optional<Aluno> found = Request. */


    /*
     * @GetMapping(path = "/teste")
     * public boolean dadoTeste(){
     * Aluno aluno = new Aluno();
     * aluno.setEmail("isconaifa@hotmail.com");
     * aluno.setEndereco("Boa Esperança");
   ;  * aluno.setMatricula("800210101");
     * repository.save(aluno);
     * return true;
     * }
     */

}
