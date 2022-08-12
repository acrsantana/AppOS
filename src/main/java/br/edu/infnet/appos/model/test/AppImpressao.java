package br.edu.infnet.appos.model.test;

import br.edu.infnet.appos.model.domain.Veiculo;
import lombok.Data;

public class AppImpressao {

    public static void relatorio(Veiculo veiculo, String mensagem){
        System.out.println(mensagem);
        veiculo.impressao();
    }

}
