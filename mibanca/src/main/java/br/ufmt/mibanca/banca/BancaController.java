package br.ufmt.mibanca.banca;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

//endpoints
@RestController
@RequestMapping(path = "/banca") // rastrear quando o final do link for "/banca"
@RequiredArgsConstructor 
public class BancaController {
    
    private final BancaRepository repository;

    @GetMapping(path = "/")
    public List<Banca> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BancaResponse> getById(@PathVariable(name = "id") int id){
        Optional<Banca> found = repository.findById(id);
        if(found.isPresent()){
            BancaResponse response = BancaResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping(path = "/{pk}")
    public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id){
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException erro) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody BancaRequest request){ 
        Banca banca = new Banca();
        banca.setDataBanca(request.getDataBanca());

        try {
            repository.save(banca);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        } 
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody BancaRequest request){
        Banca banca = new Banca();
        banca.setId(id);
        banca.setDataBanca(null);

        try {
            repository.save(banca);
        } catch (IllegalArgumentException error) {
            error.printStackTrace();
        }     
        return ResponseEntity.ok().build();
    }

   /* @GetMapping(path = "/teste")
    @Transactional
    public boolean dadoTeste(){
        Banca banca = new Banca();
        banca.setApresentacoes(null);
        banca.setAtas(null);
        banca.setAvaliacoes(null);
        banca.setCidade(null);
        banca.setDataBanca(new Date());
        banca.setFormacao(null);
        banca.setId(0);
        banca.setParticipacoes(null);

        repository.save(banca);
        return true;
    } */
}
