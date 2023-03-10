package br.ufmt.mibanca.instituto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.websocket.Decoder.Text;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "instituto")
@SequenceGenerator(name = "seqInstituto", sequenceName = "seq_instituto_id", 
allocationSize = 1)
@Getter
@Setter

public class Instituto {

    @Id
    @GeneratedValue(generator = "seqInstituto", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 200)
    private String nome;

    // @ManyToOne
    // private Cidade cidade;

    @Column(name = "universidade", length = 100)
    private String universidade;

    @Column(name = "ativo")
    private boolean ativo;
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
        Instituto other = (Instituto) obj;
        if (id != other.id)
            return false;
        return true;
    }
}