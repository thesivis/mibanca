package br.ufmt.mibanca.estado;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/estado")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoRepository repository;

    @GetMapping(path = "/")

    public List<Estado> index(){
        return repository.findAll();
    }

    //@GetMapping(path = "/teste")
    //@T
    //public boolean dadoTeste(){
      //  Estado estado = new Estado();
     //   estado.setEstado("Mato Grosso");
        
       // repository.save(estado);
       // return true;

   // }
    
}
