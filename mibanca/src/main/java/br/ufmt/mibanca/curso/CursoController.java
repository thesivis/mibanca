package br.ufmt.mibanca.curso;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        try {
            curso = cursoRepository.save(curso);    
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(CursoResponse.from(curso));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> atualizarEntidade(@PathVariable Long id, @RequestBody CursoRequest req){
        try {
            Curso savedCurso = cursoRepository.findById(id)
                        .orElseThrow(() -> new CursoNotFoundException());
            Curso curso = req.convertToCurso();
            curso.setId(savedCurso.getId());

            curso = cursoRepository.save(curso);    
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch(CursoNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody CursoRequest req){
        try {
            Curso savedCurso = cursoRepository.findById(id)
                        .orElseThrow(() -> new CursoNotFoundException());
            if(req.getCargaHoraria() != null)
                savedCurso.setCargaHoraria(req.getCargaHoraria());
            if(StringUtils.hasLength(req.getDescricao()))
                savedCurso.setDescricao(req.getDescricao());
            if(StringUtils.hasLength(req.getNome()))
                savedCurso.setNome(req.getNome());

            savedCurso = cursoRepository.save(savedCurso);    
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch(CursoNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
