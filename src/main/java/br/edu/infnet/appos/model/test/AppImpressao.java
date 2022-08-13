package br.edu.infnet.appos.model.test;

import br.edu.infnet.appos.interfaces.IPrinter;
import br.edu.infnet.appos.model.domain.Veiculo;
import lombok.Data;

public class AppImpressao {

    public static void relatorio(IPrinter objetoImprimivel, String mensagem){
        System.out.println(mensagem);
        objetoImprimivel.impressao();
    }

}
