package br.ufmt.mibanca.estado;

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
@RequestMapping(path = "/estado")
@RequiredArgsConstructor

public class EstadoController {

    private final EstadoRepository repository;

    @GetMapping(path = "/")
    public List<Estado> index(){
        return repository.findAll();
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<EstadoResponse> getById(@PathVariable int id){
      Optional<Estado> found = repository.findById(id);
      if(found.isPresent()){
        EstadoResponse response = EstadoResponse.from(found.get());
        return ResponseEntity.ok().body(response);
      }
      return ResponseEntity.notFound().build();

    }

    @DeleteMapping(path = "/{pk}")
    public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id){
        try{
          repository.deleteById(id);
          return ResponseEntity.ok().build();
      }catch(EmptyResultDataAccessException erro){
        return ResponseEntity.notFound().build();
      }

  }


  @DeleteMapping
  @PostMapping 
  public ResponseEntity<Object> cadastrar(@RequestBody EstadoRequest request){
    Estado estadoCadastrado = new Estado();
    estadoCadastrado.setEstado(request.getEstado());

    try{
      repository.save(estadoCadastrado);
    }catch(IllegalAccessError error){
      return ResponseEntity.badRequest().body("Dados Invalidos!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }


  @PatchMapping(path = "/{id}")
  public ResponseEntity<Estado> atualizar(@PathVariable int id, @RequestBody EstadoRequest request){
    Estado estadoAtualizar = new Estado();
    estadoAtualizar.setId(id);
    estadoAtualizar.setEstado(request.getEstado());
    
    try{
      repository.save(estadoAtualizar);
      return ResponseEntity.ok().build();
    }catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build(); 
    }

  }


    //@GetMapping(path = "/teste")
    //@T
    //public boolean dadoTeste(){
      //  Estado estado = new Estado();
     //   estado.setEstado("Mato Grosso");
        
       // repository.save(estado);
       // return true;

   // }
    
    }
