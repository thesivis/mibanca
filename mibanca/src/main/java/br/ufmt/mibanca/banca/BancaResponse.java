package br.ufmt.mibanca.banca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BancaResponse {
    private int id;
    private Date dataBanca;

    public static BancaResponse from(Banca entidade){
        BancaResponse response = new BancaResponse();
        response.setId(entidade.getId());
        response.setDataBanca(entidade.getDataBanca());
        return response;
    }
}
