package br.ufmt.mibanca.qualificacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufmt.mibanca.cidade.Cidade;
import br.ufmt.mibanca.pessoa.Pessoa;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "qualificacao")
@SequenceGenerator(name = "seqQualificacao", sequenceName = "sequence_qualificacao_id", allocationSize = 1)
@Data
public class Qualificacao {
    @Id
    @GeneratedValue(generator = "seqQualificacao", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "ementa", length = 2000)
    private String ementa;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

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
        Qualificacao other = (Qualificacao) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
