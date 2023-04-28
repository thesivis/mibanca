package br.ufmt.mibanca.instituto;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.User;
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
@RequestMapping(path = "/instituto")
@RequiredArgsConstructor
public class InstitutoController {

    private final InstitutoRepository repository;

    @GetMapping(path = "/")
    public List<Instituto> index() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InstitutoResponse> getById(@PathVariable int id) {
        Optional<Instituto> found = repository.findById(id);
        if (found.isPresent()) {
            InstitutoResponse response = InstitutoResponse.from(found.get());
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

    @PostMapping
    public ResponseEntity cadastrar(InstitutoRequest request) {
        Instituto instituto = new Instituto();
        instituto.setNome(request.getNome());

        try {
            repository.save(instituto);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados invalido");
        }

        repository.save(instituto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody InstitutoRequest request) {
        Instituto instituto = new Instituto();
        instituto.setId(id);
        instituto.setNome(request.getNome());

        try {
            repository.save(instituto);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().build();
        }

        repository.save(instituto);
        return ResponseEntity.ok().build();
    }

}