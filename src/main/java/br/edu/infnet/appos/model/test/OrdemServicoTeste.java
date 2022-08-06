package br.edu.infnet.appos.model.test;

import java.time.LocalDateTime;

public class OrdemServicoTeste {

    public static void main(String[] args) {
        OrdemServico os = new OrdemServico();
        os.data = LocalDateTime.now();
        os.descricao = "Lavagem";
        os.garantia=false;

        OrdemServico os2 = new OrdemServico();
        os2.data = LocalDateTime.now();
        os2.descricao = "Reparo no ar condicionado";
        os2.garantia=true;

        OrdemServico os3 = new OrdemServico();
        os3.data = LocalDateTime.now();
        os3.descricao = "Limpeza na cabine";
        os3.garantia=false;

        System.out.println(os.toString());
        System.out.println(os2);
        System.out.println(os3);
    }



}
