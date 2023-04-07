package br.ufmt.mibanca.participacao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/participacao")
@RequiredArgsConstructor
public class ParticipacaoController {
 
    private final ParticipacaoRepository repository;
@GetMapping(path = "/")
    public List<Participacao> index(){
        return repository.findAll();


    }
    
}
