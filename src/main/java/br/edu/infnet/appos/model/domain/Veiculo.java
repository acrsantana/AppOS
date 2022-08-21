package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.interfaces.IPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public abstract class Veiculo implements IPrinter {
    private String marca;
    private String modelo;
    private int anoFabricacao;

    private Integer id;

    public abstract int getPotencia();


    @Override
    public String toString() {
        return marca + ";" + modelo + ";" + anoFabricacao + ";" + getPotencia();
    }
}

