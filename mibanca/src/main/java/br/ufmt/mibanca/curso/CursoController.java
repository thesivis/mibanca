package br.ufmt.mibanca.curso;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoRepository cursoRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<CursoResponse>> findAll(){
        return ResponseEntity.ok().body(
            cursoRepository.findAll().stream()
                .map(CursoResponse::from)
                .collect(Collectors.toList())
        );
    }
    
    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<CursoResponse> findById(@PathVariable long id){
        Optional<Curso> opCurso = cursoRepository.findById(id);
        if(!opCurso.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(CursoResponse.from(opCurso.get()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable long id){
        Optional<Curso> opCurso = cursoRepository.findById(id);
        if(!opCurso.isPresent())
            return ResponseEntity.notFound().build();
        cursoRepository.delete(opCurso.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CursoResponse> save(@RequestBody CursoRequest req){
        Curso curso = req.convertToCurso();
        curso = cursoRepository.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(CursoResponse.from(curso));
    }

}
