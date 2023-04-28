package br.ufmt.mibanca.participacao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipacaoResponse {
private int id;
private Boolean presente;
private String motivoAusencia;

public static ParticipacaoResponse from(Participacao object){
ParticipacaoResponse response = new ParticipacaoResponse();
response.setId(object.getId());
response.setPresente(object.getPresente());
response.setMotivoAusencia(object.getMotivoAusencia());
return response;
}



}
