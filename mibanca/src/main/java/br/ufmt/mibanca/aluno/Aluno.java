package br.ufmt.mibanca.aluno;

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


import br.ufmt.mibanca.pessoa.Pessoa;
import br.ufmt.mibanca.apresentacao.Apresentacao;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "aluno")
@SequenceGenerator(name = "seqAluno", sequenceName =  "seq_aluno_id", allocationSize = 1)
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(generator =  "seqAluno", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "matricula", length = 100)
    private String matricula;
    @Column(name = "endereco")
    
    private String endereco;
    @Column(name =  "endereco", length =  100)
    private String email;
    @Column(name =  "email", length =  100)
    //private Pesssoa pessoa;

    @ManyToOne
       @JoinColumn(name = "pessoa_id")
       private Pessoa pessoa; 

       @OneToMany(mappedBy =  "apresentacao")
       private List<Apresentacao> apresentacoes;
      


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
        Aluno other = (Aluno) obj;
        if (id != other.id)
            return false;
        return true;
       
    }

}

