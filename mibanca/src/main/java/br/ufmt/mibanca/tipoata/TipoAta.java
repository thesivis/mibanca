package br.ufmt.mibanca.tipoata;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.mibanca.ata.Ata;

//import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter; 

@Entity
@Table(name="tipoAta")
@SequenceGenerator(name = "seqTipoAta", sequenceName = "seq_tipo_ata_id", allocationSize = 1)
@Getter
@Setter
public class TipoAta {
    @Id
    @GeneratedValue(generator = "seqTipoAta", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "descricao", length = 200)
    private String descricao;  
    
    @OneToMany(mappedBy = "tipo")
    private List<Ata> atas;

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
        TipoAta other = (TipoAta) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
