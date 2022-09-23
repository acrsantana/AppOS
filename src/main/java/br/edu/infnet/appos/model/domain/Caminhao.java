package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.exceptions.CapacidadeCargaInvalidaException;
import br.edu.infnet.appos.exceptions.ComprimentoInvalidoException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity @Table(name = "caminhoes")
@NoArgsConstructor @Setter @Getter
public class Caminhao extends Veiculo{

    private String tipo;
    private float capacidadeCarga;
    private float comprimento;
    @Transient
    private final float VALOR_BASE = 80000f;

    public Caminhao(String tipo, float capacidadeCarga, float comprimento) throws CapacidadeCargaInvalidaException {
        if (capacidadeCarga < 500)
            throw new CapacidadeCargaInvalidaException("A capacidade de carga não pode ser inferior a 500kg");
        this.tipo = tipo;
        this.capacidadeCarga = capacidadeCarga;
        this.comprimento = comprimento;
    }

    public float getValor() throws ComprimentoInvalidoException {
        if (comprimento < 5){
            throw new ComprimentoInvalidoException("O comprimento do veículo não pode ser inferior a 5 metros");
        }
        return VALOR_BASE * (comprimento/2) + capacidadeCarga;
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

