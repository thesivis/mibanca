package br.ufmt.mibanca.ata;

import java.util.Date;

import org.apache.catalina.connector.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtaResponse {
    private int id;
    private String textoAta;
    private Date data;

    public static AtaResponse from(Ata entidade){
        AtaResponse response = new AtaResponse();
        response.setId(entidade.getId());
        response.setTextoAta(entidade.getTextoAta());
        response.setData(entidade.getData());
        return response;
    }
}
