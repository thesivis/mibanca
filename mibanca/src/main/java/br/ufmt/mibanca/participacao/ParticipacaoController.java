package br.ufmt.mibanca.participacao;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/participacao")
@RequiredArgsConstructor
public class ParticipacaoController {

    private final ParticipacaoRepository repository;

    @GetMapping(path = "/")
    public List index() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        Optional<Participacao> found = repository.findById(id);
        if (found.isPresent()) {
            ParticipacaoResponse response = ParticipacaoResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{pk}")
    public ResponseEntity remover(@PathVariable(name = "pk") int id) {
        try {
            repository.deleteById(id);

            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException erro) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody ParticipacaoRequest request) {
        Participacao Participacao = new Participacao();
        Participacao.setMotivoAusencia(request.getMotivoAusencia());

        try {
            repository.save(Participacao);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados invalido");
        }

        repository.save(Participacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody ParticipacaoRequest request) {
        Participacao Participacao = new Participacao();
        Participacao.setId(id);
        Participacao.setMotivoAusencia(request.getMotivoAusencia());

        try {
            repository.save(Participacao);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().build();
        }

        repository.save(Participacao);
        return ResponseEntity.ok().build();
    }

}