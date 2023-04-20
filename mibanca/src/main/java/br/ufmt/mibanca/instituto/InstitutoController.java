package br.ufmt.mibanca.instituto;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path= "/instituto")
@RequiredArgsConstructor
public class InstitutoController {

    private final InstitutoRepository repository;

@GetMapping(path = "/")
public List<Instituto> index(){
    return repository.findAll();
}

}