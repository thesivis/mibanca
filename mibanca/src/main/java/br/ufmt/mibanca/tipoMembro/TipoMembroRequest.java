package br.ufmt.mibanca.tipoMembro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoMembroRequest {
    private int enumerador;
    private String tipo;

    public static TipoMembro to(TipoMembroRequest entidade){
        TipoMembro request = new TipoMembro();
        request.setEnumerador(entidade.getEnumerador());
        request.setTipo(entidade.getTipo());
        return request;
    }
}
