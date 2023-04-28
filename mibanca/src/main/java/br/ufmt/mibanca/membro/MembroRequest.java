package br.ufmt.mibanca.membro;

public class MembroRequest {
    private String cargo;
    private int codMatricula;
    private String instituicao;
    private String endereco;
    private String email;
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public String getCargo(){
        return this.cargo;
    }

    public void setCodMatricula(int codMatricula){
        this.codMatricula = codMatricula;
    }

    public int getCodMatricula(){
        return this.codMatricula;
    }

    public void setInstituicao(String instituicao){
        this.instituicao = instituicao;
    }

    public String getInstituicao(){
        return this.instituicao;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }


}
