package br.ufmt.mibanca.tipobanca;

public class TipoBancaRequest {
    private String nome;
    private int etapa;

    public String getNome() {
        return nome;
    }
    public int getEtapa() {
        return etapa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

}
