package br.ufmt.mibanca.participacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.mibanca.banca.Banca;
import br.ufmt.mibanca.membro.Membro;
import br.ufmt.mibanca.tipoMembro.TipoMembro;
import lombok.Getter;
import lombok.Setter;


  
@Entity
@Table(name = "participacao")
@SequenceGenerator(name = "seqParticipacao", sequenceName = "seq_participacao_id", allocationSize = 1)
@Getter
@Setter
public class Participacao {
    
    @Id
    @GeneratedValue(generator = "seqParticipacao", strategy = GenerationType.SEQUENCE)
    private int id;
    private Boolean presente;
    private String motivoAusencia;
    @ManyToOne
    @JoinColumn(name = "tipo_membro_id")
    private TipoMembro tipoMembro;
    @ManyToOne
    @JoinColumn(name = "banca_id")
    private Banca banca;
    @ManyToOne
    @JoinColumn(name = "membro_id")
    private Membro membro;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        if (id != other.id)
            return false;
        return true;
    }

}
