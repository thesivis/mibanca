package br.ufmt.mibanca.tipobanca;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice.Return;

import java.util.List;

@RestController
@RequestMapping(path = "/tipobanca")
//@RequiredArgsConstructor
    public class TipoBancaController {

    private final TipoBancaRepository repository;

    public List<TipoBanca> index() {


        return repository.findAll();
    
    }
@GetMapping(path = "/teste")
    public boolean dadoTeste(){
        TipoBanca.setDescricao("Ocorrencia");

        repository.save(tipoBanca);


Return:true;

}
 
    
