package br.ufmt.mibanca.curso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoRequest {
    private String nome;
    private String descricao;
    private int cargaHoraria;

    public Curso convertToCurso(){
        Curso curso = new Curso();
        curso.setNome(nome);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }
}
