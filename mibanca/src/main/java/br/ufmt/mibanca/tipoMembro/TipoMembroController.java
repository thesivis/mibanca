package br.ufmt.mibanca.tipoMembro;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="/tipomembro")
@RequiredArgsConstructor
public class TipoMembroController {
    
    private final TipoMembroRepository repository;

    @GetMapping(path="/")
    public List<TipoMembro> index(){
        return repository.findAll();
    }
}
