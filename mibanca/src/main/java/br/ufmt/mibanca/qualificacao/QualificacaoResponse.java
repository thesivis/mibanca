package br.ufmt.mibanca.qualificacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualificacaoResponse {
    private int id;
    private String nome;

    public static QualificacaoResponse from(Qualificacao entidade) {
        QualificacaoResponse response = new QualificacaoResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getNome());
        return response;

    }

}
