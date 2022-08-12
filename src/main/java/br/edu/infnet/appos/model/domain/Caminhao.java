package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data @AllArgsConstructor
public class Caminhao extends Veiculo{
    private String tipo;
    private float capacidadeCarga;
    private float comprimento;

    @Override public int getPotencia() {
        return super.getPotencia() + 100;
    }

    @Override public void impressao() {
        System.out.println("### Caminhão ###");
        System.out.println(toString());
    }

    @Override
    public String toString() {

        return "Caminhão: [" + tipo + ";" + capacidadeCarga + ";" + comprimento + ";" + super.toString() + "]";
    }
}

