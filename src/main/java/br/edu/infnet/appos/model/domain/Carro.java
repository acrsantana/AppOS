package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data @AllArgsConstructor
public class Carro {
    private String tipo;
    private boolean arCondicionado;
    private int portas;

    @Override
    public String toString() {
        return tipo + ";" + arCondicionado + ";" + portas;
    }
}

