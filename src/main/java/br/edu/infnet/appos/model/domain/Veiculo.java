package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data @AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private LocalDateTime anoFabricacao;

    @Override
    public String toString() {
        return marca + ";" + modelo + ";" + anoFabricacao;
    }
}

