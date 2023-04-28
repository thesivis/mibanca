package br.ufmt.mibanca.tipoata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoAtaResponse {
  private int id;
  private String descricao;

  public static TipoAtaResponse from(TipoAta entidade){
    TipoAtaResponse response = new TipoAtaResponse();
    response.setId(entidade.getId());
    response.setDescricao(entidade.getDescricao());
    return response;
  }
}
