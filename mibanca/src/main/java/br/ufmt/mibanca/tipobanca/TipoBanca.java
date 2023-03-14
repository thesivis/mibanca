package br.ufmt.mibanca.tipobanca;
import java.util.List;

//Importação de bibliotecas
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.mibanca.formacao.Formacao;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "tipo_banca")
@SequenceGenerator(name = "seqTipoBanca", sequenceName = "seq_tipo_banca_id", allocationSize = 1)
@Getter
@Setter
public class TipoBanca {

//Definição da classe Tipobanca, que possui os seguintes atributos
    @Id
    @GeneratedValue(generator = "seqTipoBanca", strategy = GenerationType.SEQUENCE) 
    private int id;

    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "etapa", length = 15)
    private int etapa;
        
    @OneToMany(mappedBy = "tipoBanca")
    private List<Formacao> formacoes;


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
        TipoBanca other = (TipoBanca) obj;
        if (id != other.id)
            return false;
        return true;
    }

}