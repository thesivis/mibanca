package br.ufmt.mibanca.apresentacao;

import java.util.Date;

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
@Table(name = "apresentacao")
@SequenceGenerator(name = "seqApresentacao", sequenceName = "Apresentacao_id", allocationSize = 1)
@Getter
@Setter

public class Apresentacao {
    @Id
    @GeneratedValue(generator = "seqApresentacao", strategy = GenerationType.SEQUENCE)

    private int id;
    @Column(name = "nome", length = 200)
    private String banca;
    @Column(name = "data_apresentacao")
    @Temporal(TemporalType.DATE)
     Date dataApresentacao;
     boolean situacao;
     float media;
     

    
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
        Apresentacao other = (Apresentacao) obj;
        if (id != other.id)
            return false;
        return true;
    }
    //private Cidade cidade;
}
