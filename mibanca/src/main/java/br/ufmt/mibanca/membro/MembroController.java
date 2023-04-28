package br.ufmt.mibanca.membro;

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
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/membro")
@RequiredArgsConstructor

public class MembroController {

    private final MembroRepository repository;

        
    @GetMapping(path = "/")
    public List<Membro> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MembroResponse> getById(@PathVariable int id){

        Optional<Membro> found = repository.findById(id);
        
        if(found.isPresent()){
            MembroResponse response = MembroResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{pk}")
    public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id){
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch(EmptyResultDataAccessException erro){
            return ResponseEntity.notFound().build();
        }
            
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody MembroRequest request){
        Membro membro = new Membro();
        membro.setCargo(request.getCargo());
        membro.setCodMatricula(request.getCodMatricula());
        membro.setInstituicao(request.getInstituicao());
        membro.setEndereco(request.getEndereco());
        membro.setEmail(request.getEmail());

        try{
            repository.save(membro); 
        } catch(IllegalArgumentException error){
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        }
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }
    
    @PatchMapping (path = "/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody MembroRequest request){
        Membro membro = new Membro();
        membro.setId(id);
        membro.setCargo(request.getCargo());
        membro.setCodMatricula(request.getCodMatricula());
        membro.setInstituicao(request.getInstituicao());
        membro.setEndereco(request.getEndereco());
        membro.setEmail(request.getEmail());

        try{
            repository.save(membro); 
            return ResponseEntity.ok().build();
        } catch(IllegalArgumentException error){
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

}


