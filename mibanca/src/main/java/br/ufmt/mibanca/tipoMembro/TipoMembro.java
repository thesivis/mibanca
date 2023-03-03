package br.ufmt.mibanca.tipoMembro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_membro")
@SequenceGenerator(name = "seqTipoMembro", sequenceName = "seq_tipo_membro_id", allocationSize = 1)
@Getter
@Setter
public class TipoMembro {
    
    @Id
    @GeneratedValue(generator = "seqTipoMembro", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "enum")
    private int enumerador;
    @Column(name = "tipo", length = 50)
    private String tipo;

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
        TipoMembro other = (TipoMembro) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
