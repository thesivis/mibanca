package br.ufmt.mibanca.aluno;
import org.apache.catalina.connector.Response;
import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResponse {
private int id;
private String email;
private String pessoa;
private String matricula;
private String endereco;

public static AlunoResponse from(Aluno entidade){
    AlunoResponse response = new AlunoResponse();
    response.setId(entidade.getId());
    response.setEmail(entidade.getEmail());
    //response.setPessoa(entidade.getPessoa());
    response.setMatricula(entidade.getMatricula());
    response.setEndereco(entidade.getEndereco());
    return response;
    /* response.endereco(entidade.getEndereco());
    response.getPessoa(entidade.getPessoa());
    response.getMatricula(entidade.getMatricula()); */
  
}


}


