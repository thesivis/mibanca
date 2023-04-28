package br.ufmt.mibanca.membro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MembroResponse {
    private int id;
    private String cargo;
    private int codMatricula;
    private String instituicao;
    private String endereco;
    private String email;
    
    public static MembroResponse from(Membro entidade){
        MembroResponse response = new MembroResponse();
        response.setId(entidade.getId());
        response.setCargo(entidade.getCargo());
        response.setCodMatricula(entidade.getCodMatricula());
        response.setInstituicao(entidade.getInstituicao());
        response.setEndereco(entidade.getEndereco());
        response.setEmail(entidade.getEmail());
        return response;

    }
    
}

