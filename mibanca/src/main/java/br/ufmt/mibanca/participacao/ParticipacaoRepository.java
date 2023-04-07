package br.ufmt.mibanca.participacao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ParticipacaoRepository  
    extends JpaRepositoryImplementation<Participacao, Integer> {
    
}
