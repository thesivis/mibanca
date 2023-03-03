package br.ufmt.mibanca.banca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Banca")
@SequenceGenerator(name = "seqBanca", sequenceName = "seq_banca_id", allocationSize = 1)
@Getter
@Setter

public class Banca {
    @Id
    @GeneratedValue
    private int id_banca;
    private int id_cidade;
    private int id_formacao;

     @Column(name = "Banca_DataBanca")
    @Temporal(TemporalType.DATE)
    public Date PessoaBanca_DataBanca;
    //@ManyToAny

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
        Banca other = (Banca) obj;
        if (id != other.id)
            return false;
        return true;
    }

}


