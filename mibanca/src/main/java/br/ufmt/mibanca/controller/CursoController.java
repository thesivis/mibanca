package br.ufmt.mibanca.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufmt.mibanca.entity.Curso;
import br.ufmt.mibanca.repository.CursoRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoRepository cursoRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }
    
}
