package br.ufmt.mibanca.cidade;

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

import br.ufmt.mibanca.estado.Estado;
import br.ufmt.mibanca.instituto.Instituto;
import br.ufmt.mibanca.banca.Banca;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cidade")
@SequenceGenerator(name = "seqCidade", sequenceName = "seq_cidade_id", allocationSize = 1)
@Getter
@Setter

public class Cidade {

    @Id
    @GeneratedValue(generator = "seqCidade", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "cod_postal", length = 15)
    private int codPostal;
    
    @ManyToOne
    @JoinColumn (name = "estado_id")
    private Estado estado;

    @OneToMany(mappedBy = "cidade")
    private List<Banca> bancas;

    @OneToMany(mappedBy = "cidade")
    private List<Instituto> institutos;

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
        Cidade other = (Cidade) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
