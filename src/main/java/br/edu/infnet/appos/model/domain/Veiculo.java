package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data @AllArgsConstructor @NoArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private int anoFabricacao;

    @Override
    public String toString() {
        return marca + ";" + modelo + ";" + anoFabricacao;
    }
}

