package br.ufmt.mibanca.pessoa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity // informando que se trata de uma entidade
@Table(name = pessoa) // inserindo nome da tabela
@SequenceGenerator(name = "seqPessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)

@Getter
@Setter
// clica em pessoa e depois aperta crlt + .
// vai em generate hashcode and equals e seleciona o atributo de comparação

// hashcode: gerar chave unica para um objeto em especifico
// equals: verifica se sao iguais atraves de verdadeiro e falso, atrave do
// atributo "id" que no caso é RG(selecionado).
public class Pessoa {

    @Id
    @GeneratedValue(generator = "seqPessoa", strategy = GenerationType.SEQUENCE) // definindo atributo como atributo
                                                                                 // gerado.
    // generator = quem
    // strategy = tipo do gerador, que será gerencial (posgitgresql)
    //

    private int id;

    private String rg;

    @Column(name = "nome", length = 200)
    public String nome;

    @Column(name = "cpf", length = 200)
    private String cpf;

    @Column(name = "dataNasc")
    @Temporal(TemporalType.DATE)
    public Date dataNasc;

    @Column(name = "email", length = 200)
    private String email;

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
        Pessoa other = (Pessoa) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
