package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int anoFabricacao;

    public int getPotencia(){
        return anoFabricacao > 2015 ? 180 : 150;
    }

    public abstract void impressao();

    @Override
    public String toString() {
        return marca + ";" + modelo + ";" + anoFabricacao + ";" + getPotencia();
    }
}

