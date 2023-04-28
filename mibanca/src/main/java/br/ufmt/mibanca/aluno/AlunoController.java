package br.ufmt.mibanca.aluno;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.status.Status;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/aluno")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoRepository repository;

    @GetMapping(path = "/")
    public List<Aluno> index() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AlunoResponse> getById(@PathVariable int id) {
        Optional<Aluno> found = repository.findById(id);
        if (found.isPresent()) {
            AlunoResponse response = AlunoResponse.from(found.get());
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
            // TODO: handle exception
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity cadastrar(@RequestBody AlunoRequest request) {
        Aluno aluno = new Aluno();
        aluno.setEmail(request.getEmail());
        aluno.setEndereco(request.getEndereco());
        aluno.setMatricula(request.getMatricula());
        // repository.save(aluno);

        try {
            repository.save(aluno);
        } catch (IllegalAccessError error) {
            return ResponseEntity.badRequest().body("Dados invalido");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
        // TODO: handle exception
    }

    @PatchMapping(path = "{/id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody AlunoRequest request) {
        Aluno aluno = new Aluno();
        aluno.setId(id);
        aluno.setEmail(request.getEmail());
        aluno.setEndereco(request.getEndereco());
        aluno.setMatricula(request.getMatricula());

        try {
            repository.save(aluno);
            return ResponseEntity.ok().build();
        } catch (IllegalAccessError error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}