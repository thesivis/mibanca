package br.ufmt.mibanca.tipoata;

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
@RequestMapping(path = "/tipoata")
@RequiredArgsConstructor
public class TipoAtaController {
  
  private final TipoAtaRepository repository;

  @GetMapping(path = "/")
  public List<TipoAta> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<TipoAtaResponse> getById(@PathVariable(name = "id") int id) {
    Optional<TipoAta> found = repository.findById(id);
    if(found.isPresent()){
      TipoAtaResponse response = TipoAtaResponse.from(found.get());
      return ResponseEntity.ok().body(response);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping(path = "/{pk}")
  public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id){
    try {
      repository.deleteById(id);
      return ResponseEntity.ok().build();
    } catch(EmptyResultDataAccessException erro){
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity cadastrar(@RequestBody TipoAtaRequest request){
    TipoAta tipoAta = new TipoAta();
    tipoAta.setDescricao(request.getDescricao());

    try {
      repository.save(tipoAta);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity atualizar(@PathVariable int id,
                                @RequestBody TipoAtaRequest request){
    TipoAta tipoAta = new TipoAta();
    tipoAta.setId(id);
    tipoAta.setDescricao(request.getDescricao());

    try {
      repository.save(tipoAta);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}
