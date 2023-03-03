package br.ufmt.mibanca.estado;

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
@Table(name = "estado")
@SequenceGenerator(name = "seqEstado", sequenceName = "seq_estado_id", allocationSize = 1)
@Getter
@Setter
public class Estado {
    
    @Id
    @GeneratedValue(generator = "seqEstado", strategy = GenerationType.SEQUENCE)
    private int id;
    //@ManyToOne
    //private Pais pais;
    @Column(name = "estado", length = 50)
    private String estado;

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
        Estado other = (Estado) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
