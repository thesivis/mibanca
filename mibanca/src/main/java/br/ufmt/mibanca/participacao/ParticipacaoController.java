package br.ufmt.mibanca.participacao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/participacao")
@RequiredArgsConstructor
public class ParticipacaoController {
 
    private final ParticipacaoRepository repository;
    
    @GetMapping(path = "/")
    public List<Participacao> index(){
        return repository.findAll();
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Participacao> show(@PathVariable Integer id){
        Optional<Participacao> participacao = repository.findById(id);
        if(participacao.isPresent()){
            return ResponseEntity.ok(participacao.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping(path = "/")
    public Participacao create(@RequestBody Participacao participacao){
        return repository.save(participacao);
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<Participacao> update(@PathVariable Integer id, @RequestBody Participacao participacaoAtualizada){
        Optional<Participacao> participacaoExistente = repository.findById(id);
        if(participacaoExistente.isPresent()){
            Participacao participacao = participacaoExistente.get();
            participacao.setPresente(participacaoAtualizada.isPresente());
            participacao.setMotivoAusencia(participacaoAtualizada.getMotivoAusencia());
            repository.save(participacao);
            return ResponseEntity.ok(participacao);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Optional<Participacao> participacao = repository.findById(id);
        if(participacao.isPresent()){
            repository.delete(participacao.get());
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
}
