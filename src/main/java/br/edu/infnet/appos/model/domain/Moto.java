package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.exceptions.QuantidadePassageirosInvalidaException;
import lombok.Data;

@Data
public class Moto extends Veiculo{
    private int cilindrada;
    private String estilo;
    private int quantidadeDePassageiros;

    public Moto(int cilindrada, String estilo, int quantidadeDePassageiros) throws QuantidadePassageirosInvalidaException {
        if (quantidadeDePassageiros < 1)
            throw new QuantidadePassageirosInvalidaException("Veículo precisa ter ao menos 1 passageiro");
        if (quantidadeDePassageiros > 2)
            throw new QuantidadePassageirosInvalidaException("Veículo não pode ter mais que 2 passageiro");
        this.cilindrada = cilindrada;
        this.estilo = estilo;
        this.quantidadeDePassageiros = quantidadeDePassageiros;
    }

    @Override public int getPotencia() {
        return cilindrada;
    }

    @Override public void impressao() {
        System.out.println("### Moto ###");
        System.out.println(toString());
    }

    public boolean isCiclomotor(){
        return cilindrada < 50;
    }

    @Override
    public String toString() {

        return "Moto: [" + cilindrada + ";" + estilo + ";" + quantidadeDePassageiros + ";" + super.toString() + "]";
    }
}


