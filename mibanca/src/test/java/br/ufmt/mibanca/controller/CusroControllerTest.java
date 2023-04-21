package br.ufmt.mibanca.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import br.ufmt.mibanca.curso.Curso;
import br.ufmt.mibanca.curso.CursoRepository;
import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ActiveProfiles("test")
public class CusroControllerTest {

    private final CursoRepository repository;

    @Test
    @Transactional
    @Rollback(false)
    public void GivenMockDataThenSaveInDatabase(){
        Curso curso = new Curso();
        curso.setCargaHoraria(200);
        curso.setDescricao("Alg é um curso muito legal");
        curso.setNome("ALG");

        curso = repository.saveAndFlush(curso);
        System.out.println("Senhorita nat");
    }
    
}
