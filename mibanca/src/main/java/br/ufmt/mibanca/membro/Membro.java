package br.ufmt.mibanca.membro;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.mibanca.avaliacao.Avaliacao;
import br.ufmt.mibanca.participacao.Participacao;
import br.ufmt.mibanca.pessoa.Pessoa;
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

    @Column(name = "cod_matricula")
    private int codMatricula;

    @Column(name = "intituicao", length = 200)
    private String instituicao;
    
    @Column(name = "endereco", length = 400)
    private String endereco;
    
    @Column(name = "email", length = 200)
    private String email;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToMany(mappedBy = "membro")
    private List<Participacao> participacoes;

    @OneToMany(mappedBy = "membro")
    private List<Avaliacao> avaliacoes;

    
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
