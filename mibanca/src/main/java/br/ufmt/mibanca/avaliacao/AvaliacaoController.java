package br.ufmt.mibanca.avaliacao;

import java.util.List;

import javax.annotation.Generated;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
