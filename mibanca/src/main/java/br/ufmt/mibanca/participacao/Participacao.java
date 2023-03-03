package br.ufmt.mibanca.participacao;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


  
@Entity
@Table(name = "participacao")
@SequenceGenerator(name = "seqParticipacao", sequenceName = "seq_participacao_id", allocationSize = 1)
@Getter
@Setter
public class Participacao {
    
    private int id_participacao;
    private int id_tipo_membro;
    private int id_membro;
    private Boolean presente;
    private String motivo_ausencia;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_participacao;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Participacao other = (Participacao) obj;
        if (id_participacao != other.id_participacao)
            return false;
        return true;
    }

}
