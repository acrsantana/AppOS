package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data @AllArgsConstructor
public class Caminhao extends Veiculo{
    private String tipo;
    private float capacidadeCarga;
    private float comprimento;

    @Override
    public String toString() {
        return tipo + ";" + capacidadeCarga + ";" + comprimento + ";" + super.toString();
    }
}

