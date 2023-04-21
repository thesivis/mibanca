package br.ufmt.mibanca.tipoMembro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoMembroResponse {
    private int id;
    private int enumerador;
    private String tipo;

    public static TipoMembroResponse from(TipoMembro entidade){
        TipoMembroResponse response = new TipoMembroResponse();
        response.setId(entidade.getId());
        response.setEnumerador(entidade.getEnumerador());
        response.setTipo(entidade.getTipo());
        return response;
    }
}
