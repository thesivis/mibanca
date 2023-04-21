package br.ufmt.mibanca.curso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoResponse {
    private long id;
    private String nome;
    private String descricao;
    private int cargaHoraria;

    public static final CursoResponse from(Curso curso){
        return CursoResponse.builder()
                .id(curso.getId())
                .nome(curso.getNome())
                .cargaHoraria(curso.getCargaHoraria())
                .descricao(curso.getDescricao())
            .build();
    }
}
