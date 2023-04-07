package br.ufmt.mibanca.tipoata;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
