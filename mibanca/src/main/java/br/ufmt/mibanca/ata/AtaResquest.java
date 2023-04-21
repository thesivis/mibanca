package br.ufmt.mibanca.ata;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtaResquest {
    private String textoAta;
    private Date data;

    public static Ata from(AtaResquest ataRequest){
        Ata request = new Ata();
        request.setTextoAta(ataRequest.getTextoAta());
        request.setData(ataRequest.getData());
        return request;
    }
}
