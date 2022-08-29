package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.exceptions.CapacidadeCargaInvalidaException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Caminhao extends Veiculo{
    private String tipo;
    private float capacidadeCarga;
    private float comprimento;

    public Caminhao(String tipo, float capacidadeCarga, float comprimento) throws CapacidadeCargaInvalidaException {
        if (capacidadeCarga < 500)
            throw new CapacidadeCargaInvalidaException("A capacidade de carga não pode ser inferior a 500kg");
        this.tipo = tipo;
        this.capacidadeCarga = capacidadeCarga;
        this.comprimento = comprimento;
    }

    @Override public int getPotencia() {
        return getAnoFabricacao() > 2015 ? 240 : 200;
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

