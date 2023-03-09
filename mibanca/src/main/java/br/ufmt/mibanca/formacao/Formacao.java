package br.ufmt.mibanca.formacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "formacao")
@SequenceGenerator(name="seqFormacao", sequenceName = "seq_formacao_id", allocationSize = 1)
@Getter
@Setter
public class Formacao {
    @Id
    @GeneratedValue (generator = "seqFormacao", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "nome", length = 200)
    private String nome;
    @Column(name="carga_horaria")
    private float cargaHoraria;
    @ManyToOne 
    //private Curso curso;
    //private Tipo_Banca tipo_Banca;
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
        Formacao other = (Formacao) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
