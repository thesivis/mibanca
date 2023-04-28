package br.ufmt.mibanca.avaliacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoRequest {
    private String comentario;
    private Float nota;

    public void setComentario(String comentario){
        this.comentario = comentario;
    }

    public String getComentario(){
        return comentario;

    }  

    public void setNota(Float nota){
        this.nota = nota;
    }

    public Float getNota(){
        return nota;
    }
        
        

}
