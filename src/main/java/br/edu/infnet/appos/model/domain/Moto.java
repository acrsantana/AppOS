package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data @AllArgsConstructor
public class Moto extends Veiculo{
    private int cilindrada;
    private String modelo;
    private int quantidadeDePassageiros;

    @Override public int getPotencia() {
        return cilindrada;
    }

    @Override public void impressao() {
        System.out.println("### Moto ###");
        System.out.println(toString());
    }

    public boolean isCiclomotor(){
        return cilindrada < 50 ? true : false;
    }

    @Override
    public String toString() {

        return "Moto: [" + cilindrada + ";" + modelo + ";" + quantidadeDePassageiros + ";" + super.toString() + "]";
    }
}


