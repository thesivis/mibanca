package br.ufmt.mibanca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufmt.mibanca.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    
}
