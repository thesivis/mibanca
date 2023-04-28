package br.ufmt.mibanca.avaliacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoResponse {
    private int id;
    private String comentario;
    private float nota;

    public static AvaliacaoResponse from(Avaliacao entidade){
        AvaliacaoResponse response = new AvaliacaoResponse();
        response.setId(entidade.getId());
        response.setComentario(entidade.getComentario());
        response.setNota(entidade.getNota());
        return response;
    }
    
}
