package br.ufmt.mibanca.cidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cidade")
@SequenceGenerator(name = "seqCidade", sequenceName = "seq_cliente_id", allocationSize = 1)
@Getter
@Setter

public class Cidade {

    @Id
    @GeneratedValue(generator = "seqCidade", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "nome", length = 200)
    private String nome;
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
        Cidade other = (Cidade) obj;
        if (id != other.id)
            return false;
        return true;
    }

    
}
