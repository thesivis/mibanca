package br.ufmt.mibanca.tipobanca;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/tipoBanca")
@RequiredArgsConstructor
public class TipoBancaController {

    private final TipoBancaRepository repository;

    @GetMapping(path = "/")
    public List<TipoBanca> index() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TipoBanca> getById(@PathVariable(name = "id") int id) {

        Optional<TipoBanca> found = repository.findById(id);

        if (found.isPresent()) {
            return ResponseEntity.ok().body(found.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody TipoBancaRequest request) {

        TipoBanca tipoBanca = new TipoBanca();

        tipoBanca.setNome(request.getNome());
        tipoBanca.setEtapa(request.getEtapa());

        try {

            repository.save(tipoBanca);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados inválidos!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody TipoBancaRequest request) {

        TipoBanca tipoBanca = new TipoBanca();
        tipoBanca.setId(id);
        tipoBanca.setNome(request.getNome());
        tipoBanca.setEtapa(request.getEtapa());

        try {
            repository.save(tipoBanca);
        } catch (IllegalArgumentException error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
