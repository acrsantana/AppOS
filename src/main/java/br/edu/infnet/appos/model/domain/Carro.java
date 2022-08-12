package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data @AllArgsConstructor
public class Carro extends Veiculo{
    private String tipo;
    private boolean arCondicionado;
    private int portas;

    @Override public void impressao() {
        System.out.println("### Carro ###");
        System.out.println(toString());
    }

    @Override
    public String toString() {

        return "Carro: [" + tipo + ";" + arCondicionado + ";" + portas + ";" + super.toString() + "]";
    }
}

