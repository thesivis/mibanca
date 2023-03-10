package br.ufmt.mibanca.banca;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import br.ufmt.mibanca.apresentacao.Apresentacao;
import br.ufmt.mibanca.ata.Ata;
import br.ufmt.mibanca.avaliacao.Avaliacao;
import br.ufmt.mibanca.cidade.Cidade;
import br.ufmt.mibanca.formacao.Formacao;
import br.ufmt.mibanca.participacao.Participacao;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity // informando que se trata de uma entidade
@Table(name = "banca") // inserindo nome da tabela
@SequenceGenerator(name = "seqBanca", sequenceName = "seq_banca_id", allocationSize = 1)
@Getter
@Setter
// clica em pessoa e depois aperta crlt + .
// vai em generate hashcode and equals e seleciona o atributo de comparação

// hashcode: gerar chave unica para um objeto em especifico
// equals: verifica se sao iguais atraves de verdadeiro e falso, atrave do
// atributo "id" que no caso é RG(selecionado).

public class Banca {
    @Id
    @GeneratedValue(generator = "seqBanca", strategy = GenerationType.SEQUENCE) // definindo atributo como atributo gerado.
    private int id_banca;
    // generator = quem
    // strategy = tipo do gerador, que será gerencial (postgresql)
    //

    @Column(name = "data_banca") //caso a coluna seja String, definir length
    @Temporal(TemporalType.DATE)
    private Date dataBanca;

//---------------------------------------------
    @ManyToOne
    @JoinColumn(name="formacao_id")
    private Formacao formacao;

    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;
//----------------------------------------------
    @OneToMany(mappedBy = "banca") //ata
    private List<Ata> atas;

    @OneToMany(mappedBy = "banca") //apresentação
    private List<Apresentacao> apresentacoes;

    @OneToMany(mappedBy = "banca") //avaliação
    private List<Avaliacao> avaliacoes;

    @OneToMany(mappedBy = "banca") //participação
    private List<Participacao> participacoes;
//---------------------------------------------

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_banca;
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
        Banca other = (Banca) obj;
        if (id_banca != other.id_banca)
            return false;
        return true;
    }

}


