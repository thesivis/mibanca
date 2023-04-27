package br.ufmt.mibanca.qualificacao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
            return ResponseEntity.notFound();
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
}
