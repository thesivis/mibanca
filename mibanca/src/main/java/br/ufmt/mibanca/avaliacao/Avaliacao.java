package br.ufmt.mibanca.avaliacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.mibanca.apresentacao.Apresentacao;
import br.ufmt.mibanca.banca.Banca;
import br.ufmt.mibanca.membro.Membro;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "avaliacao")
@SequenceGenerator(name = "avaliacao", sequenceName = "seq_avaliacao_id", allocationSize = 1)
@Getter
@Setter
public class Avaliacao {

    @Id
    @GeneratedValue(generator = "Avaliacao", strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    @JoinColumn(name="banca_id")
    private Banca banca;
    @ManyToOne
    @JoinColumn(name="membro_id")
    private Membro membro;
    @ManyToOne
    @JoinColumn(name="apresentacao_id")
    private Apresentacao apresentacao;
    private float nota;
    private String comentario;

    @Override
    public int hashCode() {
        final int prime = 10;
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
        Avaliacao other = (Avaliacao) obj;
        if (id != other.id)
            return false;
        return true;
    }

}

