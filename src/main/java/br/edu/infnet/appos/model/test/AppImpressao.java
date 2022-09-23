package br.edu.infnet.appos.model.test;

import br.edu.infnet.appos.exceptions.ProblemasNaLeituraDoArquivoException;
import br.edu.infnet.appos.interfaces.IPrinter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppImpressao {

    public static void relatorio(IPrinter objetoImprimivel, String mensagem) throws ProblemasNaLeituraDoArquivoException {
        System.out.println(mensagem);
        objetoImprimivel.impressao();

    }

}
