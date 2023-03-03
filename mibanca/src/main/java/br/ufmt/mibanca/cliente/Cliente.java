package br.ufmt.mibanca.cliente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "seqCliente", sequenceName = "seq_cliente_id"
,allocationSize = 1)
@Getter
@Setter
public class Cliente {

  @Id
  @GeneratedValue(generator = "seqCliente", strategy = GenerationType.SEQUENCE)
  private int id;
  @Column(name = "nome", length = 200)
  private String nome;
  @Column(name = "data_nascimento")
  @Temporal(TemporalType.DATE)
  private Date dataNascimento;
  //@ManyToOne
  //private Cidade cidade;

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
    Cliente other = (Cliente) obj;
    if (id != other.id)
      return false;
    return true;
  }

}
