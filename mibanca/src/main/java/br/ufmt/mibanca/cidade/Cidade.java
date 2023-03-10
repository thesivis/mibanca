package br.ufmt.mibanca.cidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cidade")
@SequenceGenerator(name = "seqCidade", sequenceName = "seq_cidade_id", allocationSize = 1)
@Getter
@Setter

public class Cidade {

    @Id
    @GeneratedValue(generator = "seqCidade", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "cod_postal", length = 15)
    private int cod_postal;
    
    //@ManyToOne
    //@JoinColumn (columnDefinition = "id_estado", referencedColumnName = "id")
    //private Estado estado;
    

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
