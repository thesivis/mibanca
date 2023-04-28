package br.ufmt.mibanca.tipobanca;

import java.util.Optional;
import org.apache.catalina.connector.Response;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TipoBancaResponse {
    private int id;
    private String descrição;
    private int etapa;

    public static TipoBancaResponse from(TipoBanca entidade) {
        TipoBancaResponse response = new TipoBancaResponse();
        response.setId(entidade.getId()); 
        response.setDescrição(entidade.getNome()); 
        response.setEtapa(entidade.getEtapa());
        return response;
    }
}

