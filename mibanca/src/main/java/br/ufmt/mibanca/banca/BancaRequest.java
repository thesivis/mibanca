package br.ufmt.mibanca.banca;

import java.util.Date;

public class BancaRequest {
    private Date dataBanca;

    public void setDataBanca (Date dataBanca){
        this.dataBanca = dataBanca;
    }

    public Date getDataBanca (){
        return dataBanca;
    }
}
