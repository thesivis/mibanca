package br.ufmt.mibanca.aluno;

import org.hibernate.loader.custom.Return;

import lombok.Getter;

public class AlunoRequest {
    private String endereco;
    private String email;
    private String matricula;
  


public void setEndereco (String enderco){
    this.endereco = enderco;
}
public String getEndereco(){
    return endereco;
}


public void setEmail(String email){
    this.email = email;
}
public String getEmail(){
    return email;
}

public void setMatricula(String matricula){
    this.matricula = matricula;
}

public String getMatricula(){
    return matricula;
}
}



