package br.ufmt.mibanca.instituto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstitutoResponse {
    private int id;
    private String nome;
    private String universidade;

    public static InstitutoResponse from(Instituto entidade){
        InstitutoResponse response = new InstitutoResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getNome());
        response.setUniversidade(entidade.getUniversidade());
        return response;
    }


}