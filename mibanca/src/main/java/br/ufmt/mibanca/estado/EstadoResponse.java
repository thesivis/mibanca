package br.ufmt.mibanca.estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoResponse {
    private int id;
    private String estado;
    
    public static EstadoResponse from(Estado entidade){
        EstadoResponse  response = new EstadoResponse();
        response.setId(entidade.getId());
        response.setEstado(entidade.getEstado());
        return response;
    }
}