package br.ufmt.mibanca.avaliacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "avaliacao")
@SequenceGenerator(name = "avaliacao", sequenceName = "id_avaliacao_id", allocationSize = 1)
@Getter
@Setter
public class Avaliacao {

    @Id
    @GeneratedValue(generator = "Avaliacao", strategy = GenerationType.SEQUENCE)
    private int id_avaliacao;
    private Boolean presente;
    private String motivo_ausencia;
    //@ManyToOne
    //private tipo_membro tipo_membro;
    //private membro membro;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_avaliacao;
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
        Avaliacao other = (Avaliacao) obj;
        if (id_avaliacao != other.id_avaliacao)
            return false;
        return true;
    }

}
