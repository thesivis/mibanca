package br.ufmt.mibanca.apresentacao;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping(path = "/tipoapresentacao")
@RequiredArgsConstructor
public class ApresentacaoController {

    private final ApresentacaoRepository repository;

    @GetMapping(path = "/")
    public List<Apresentacao> index(){
        return repository.findAll();
    }
    
}

