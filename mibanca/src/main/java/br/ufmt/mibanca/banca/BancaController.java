package br.ufmt.mibanca.banca;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

//primeiro endpoint
@RestController
@RequestMapping(path = "/banca") // rastrear quando o final do link for "/banca"
@RequiredArgsConstructor 
public class BancaController {
    
    private final BancaRepository repository;

    @GetMapping(path = "/")
    public List<Banca> index(){
        return repository.findAll();
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
