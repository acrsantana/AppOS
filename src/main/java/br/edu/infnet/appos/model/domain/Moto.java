package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data @AllArgsConstructor
public class Moto {
    private int cilindrada;
    private String modelo;
    private int quantidadeDePassageiros;

    @Override
    public String toString() {
        return cilindrada + ";" + modelo + ";" + quantidadeDePassageiros;
    }
}


