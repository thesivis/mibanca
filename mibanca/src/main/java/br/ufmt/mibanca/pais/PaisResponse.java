package br.ufmt.mibanca.pais;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaisResponse {
    private int id;
    private String nome;

public static PaisResponse from(Pais entidade) {
    PaisResponse response = new PaisResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    return response;
}

}


