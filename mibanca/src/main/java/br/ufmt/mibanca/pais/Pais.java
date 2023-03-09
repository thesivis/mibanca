package br.ufmt.mibanca.pais;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pais")
@SequenceGenerator(name = "seqPais" , sequenceName = "sequence_pais", allocationSize = 1)
public class Pais {
    @Id
    @GeneratedValue(generator = "seqPais", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "nome", length = 200)
    private String nome;   
    @Column(name = "codTelefone", length = 200)
    private int codTelefone;
      
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
        Pais other = (Pais) obj;
        if (id_pais != other.id)
            return false;
        return true;
    }
    //private Cidade cidade;
}
