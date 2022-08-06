package br.edu.infnet.appos.model.test;

import java.time.LocalDateTime;

public class OrdemServicoTeste {

    public static void main(String[] args) {
        String descricao = "Reparo no ar condicionado";
        LocalDateTime data = LocalDateTime.now();
        boolean garantia = true;

        String descricao2 = "Troca do escapamento";
        LocalDateTime data2 = LocalDateTime.now();
        boolean garantia2 = false;

        String descricao3 = "Limpeza da cabine";
        LocalDateTime data3 = LocalDateTime.now();
        boolean garantia3 = true;

        System.out.println(descricao + ";" + data + ";" + garantia);
        System.out.println(descricao2 + ";" + data2 + ";" + garantia2);
        System.out.println(descricao3 + ";" + data3 + ";" + garantia3);
    }



}
