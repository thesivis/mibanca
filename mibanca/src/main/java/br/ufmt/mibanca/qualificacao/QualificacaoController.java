package br.ufmt.mibanca.qualificacao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.runner.Request;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<QualificacaoResponse> getById(@PathVariable(name = "id") int id) {
        Optional<Qualificacao> found = repository.findById(id);
        if (found.isPresent()) {
            QualificacaoResponse response = QualificacaoResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping(path = "/{pk}")
    public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();

        } catch (EmptyResultDataAccessException erro) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<QualificacaoResponse> RequestedById(@PathVariable(name = "id") int id) {
        Optional<Qualificacao> found = repository.findById(id);
        if (found.isPresent()) {
            QualificacaoResponse response = QualificacaoResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody Qualificacao request) {
        Qualificacao qualificacao = new Qualificacao();
        qualificacao.setEmenta(request.getEmenta());
        try {
            repository.save(qualificacao);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados Inválidos !");

        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * @param id
     * @param request
     * @return
     */
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody Qualificacao request) {
        Qualificacao qualificacao = new Qualificacao();
        qualificacao.setId(id);
        qualificacao.setEmenta(request.getEmenta());

        try {
            repository.save(qualificacao);
        } catch (IllegalArgumentException error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();

        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}