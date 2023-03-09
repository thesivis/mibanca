package br.ufmt.mibanca.membro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="membro")
@SequenceGenerator(name= "seqMembro", sequenceName = "seq_membro_id", allocationSize = 1)
@Getter
@Setter
public class Membro {


    @Id
    @GeneratedValue(generator = "seqMembro", strategy = GenerationType.SEQUENCE)

    private int id;
    @Column(name = "cargo", length = 200)
    private String cargo;
    @Column(name = "codMatricula")
    private int codMatricula;
    @Column(name = "intituicao", length = 200)
    private String instituicao;
    @Column(name = "endereco", length = 400)
    private String endereco;
    @Column(name = "email", length = 200)
    private String email;
    //@ManyToOne
    //private Pessoa pessoa;

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
        Membro other = (Membro) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
}
