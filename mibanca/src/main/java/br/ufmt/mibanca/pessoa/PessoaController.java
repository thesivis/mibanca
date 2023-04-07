package br.ufmt.mibanca.pessoa;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/pessoa")
@RequiredArgsConstructor //cria um metodo construtor com o conteudo da linha 13 obrigatorio
public class PessoaController {
    
    private final PessoaRepository repository;

    @GetMapping(path = "/")

    //endpoint vai retornar tudo que esta no banco (a 1° endpoint)
    public List<Pessoa> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/teste")
    @Transactional
    public boolean dadoTeste(){
        Pessoa pessoa = new Pessoa();



        //comando para salvar no banco (abaixo)
        repository.save(pessoa);
        return true;
    }

}
