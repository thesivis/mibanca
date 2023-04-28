package br.ufmt.mibanca.avaliacao;

import java.util.List;
import java.util.Optional;

import javax.annotation.Generated;
import javax.persistence.Id;
import javax.transaction.Transactional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/avaliacao")
@RequiredArgsConstructor
public class AvaliacaoController {
    
    private final AvaliacaoRepository repository;

    @GetMapping(path = "/")
    public List<Avaliacao> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
public ResponseEntity<AvaliacaoResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Avaliacao> found = repository.findById(id);
    if(found.isPresent()){
        AvaliacaoResponse response = AvaliacaoResponse.from(found.get());
        return ResponseEntity.ok().body(response);
    }
    return ResponseEntity.notFound().build();
}

@DeleteMapping(path = "/{pk}")
public ResponseEntity remover(@PathVariable(name = "pk")int id){
    try{
        repository.deleteById(id);
        return ResponseEntity.ok().build();

    }catch(EmptyResultDataAccessException erro){
        return ResponseEntity.notFound().build();
    }
    
    
}
@PostMapping
public ResponseEntity cadastrar(@RequestBody AvaliacaoRequest request){
    Avaliacao avaliacao = new Avaliacao();
    
    avaliacao.setComentario(request.getComentario());
   
    avaliacao.setNota((request.getNota()));


    try{
        repository.save(avaliacao);
    }catch(IllegalArgumentException error){
        return ResponseEntity.badRequest().body("Dados Invalido!");
    }

    return ResponseEntity.status(HttpStatus.CREATED).build();

}
@PatchMapping(path = "/{id}")
public ResponseEntity atualizar(@PathVariable int id, @RequestBody AvaliacaoRequest request){
    Avaliacao avaliacao = new Avaliacao();
    avaliacao.setId(id);
    avaliacao.setComentario(request.getComentario());
    avaliacao.setNota(request.getNota());

    try{

        repository.save(avaliacao);
    }catch(IllegalArgumentException error){
        error.printStackTrace();
        return ResponseEntity.badRequest().build();

    }

    
    return ResponseEntity.ok().build();

}
}

