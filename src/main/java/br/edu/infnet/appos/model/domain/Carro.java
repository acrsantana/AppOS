package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.exceptions.QuantidadePortasInvalidasException;
import lombok.Data;
@Data
public class Carro extends Veiculo{
    private String tipo;
    private boolean arCondicionado;
    private int portas;

    public Carro(String tipo, boolean arCondicionado, int portas) throws QuantidadePortasInvalidasException {
        if (portas < 2)
            throw new QuantidadePortasInvalidasException("Total de portas não pode ser inferior a 2");
        if (portas > 4)
            throw new QuantidadePortasInvalidasException("Total de portas não pode ser superior a 4");
        this.tipo = tipo;
        this.arCondicionado = arCondicionado;
        this.portas = portas;
    }

    @Override public void impressao() {
        System.out.println("### Carro ###");
        System.out.println(toString());
    }

    @Override public int getPotencia() {
        return getAnoFabricacao() > 2015 ? 150 : 180;
    }

    @Override
    public String toString() {

        return "Carro: [" + tipo + ";" + arCondicionado + ";" + portas + ";" + super.toString() + "]";
    }
}

