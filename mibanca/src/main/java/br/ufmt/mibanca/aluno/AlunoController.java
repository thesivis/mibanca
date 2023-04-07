package br.ufmt.mibanca.aluno;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path= "/aluno")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoRepository repository;

    @GetMapping(path = "/")
    public List<Aluno> index(){
        return repository.findAll();
    }

    // @GetMapping(path = "/teste")
    // public boolean dadoTeste(){
    //     Aluno aluno = new Aluno();
    //     aluno.setEmail("isconaifa@hotmail.com");
    //     aluno.setEndereco("Boa Esperança");
    //     aluno.setMatricula("800210101");
    //     repository.save(aluno);
    //     return true;
    // }
}

