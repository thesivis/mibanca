package br.ufmt.mibanca.ata;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufmt.mibanca.banca.Banca;
import br.ufmt.mibanca.tipoata.tipoata;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ata")
@SequenceGenerator(name = "seqAta", sequenceName="seq_ata_id", allocationSize=1)
@Getter
@Setter
public class Ata {
    
    @Id
    @GeneratedValue(generator ="seqAta", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(name = "texto", length = 2100)
    private String textoAta;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "tipo_ata_id")
    private tipoata tipo;
    
    @ManyToOne
    @JoinColumn(name = "banca_id")
    private Banca banca;


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
        Ata other = (Ata) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
