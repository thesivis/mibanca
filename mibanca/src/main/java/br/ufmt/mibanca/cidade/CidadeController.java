package br.ufmt.mibanca.cidade;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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

    // @GetMapping(path = "/teste")
    // @Transactional
    // public boolean dadoTeste() {
        
    //     Cidade cidade = new Cidade();
    //     cidade.setNome("Cuiabá");
        
    //     repository.save(cidade);
    //     return true; 
    // }

}