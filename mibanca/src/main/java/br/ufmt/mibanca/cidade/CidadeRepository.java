package br.ufmt.mibanca.cidade;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface CidadeRepository 
  extends JpaRepositoryImplementation<Cidade, Integer> {
  
}
