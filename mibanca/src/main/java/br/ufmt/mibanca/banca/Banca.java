package br.ufmt.mibanca.banca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity // informando que se trata de uma entidade
@Table(name = "Banca") // inserindo nome da tabela
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
    @GeneratedValue(generator = "seq_banca_id", strategy = GenerationType.SEQUENCE) // definindo atributo como atributo gerado.
    private int id;
    // generator = quem
    // strategy = tipo do gerador, que será gerencial (postgresql)
    //

    //private int id_cidade;
    //private int id_formacao;

     @Column(name = "Banca_DataBanca")
    @Temporal(TemporalType.DATE)
    public Date data;


    //@ManyToOne
    //private Formacao formacao
    //private Cidade cidade

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
        Banca other = (Banca) obj;
        if (id != other.id)
            return false;
        return true;
    }

}


