package br.ufmt.mibanca.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.ufmt.mibanca.entity.Curso;

public interface CursoRepository extends JpaRepositoryImplementation<Curso,Long> {
    
}
