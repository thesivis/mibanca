package br.ufmt.mibanca.qualificacao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/qualificacao")
@RequiredArgsConstructor
public class QualificacaoController {

    private final QualificacaoRepository repository;

    @GetMapping(path = "/")
    public List<Qualificacao> index() {
        return repository.findAll();
    }

}
