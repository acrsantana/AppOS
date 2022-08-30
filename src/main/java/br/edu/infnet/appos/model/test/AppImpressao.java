package br.edu.infnet.appos.model.test;

import br.edu.infnet.appos.exceptions.ProblemasNaLeituraDoArquivoException;
import br.edu.infnet.appos.interfaces.IPrinter;
import br.edu.infnet.appos.model.domain.Veiculo;
import lombok.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppImpressao {

    public static void relatorio(IPrinter objetoImprimivel, String mensagem) throws ProblemasNaLeituraDoArquivoException {
        System.out.println(mensagem);
        objetoImprimivel.impressao();
        String diretorio = "d:\\";
        String nomeArquivo = "ordensServico.txt";
        try {
            FileReader fileReader = new FileReader(diretorio + nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            System.out.println(linha);
            while (linha != null){
                System.out.println(linha);
                linha = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            throw new ProblemasNaLeituraDoArquivoException("Arquivo não encontrado");
        } catch (IOException e) {
            throw new ProblemasNaLeituraDoArquivoException("Erro na leitura do arquivo");
        } finally {
            System.out.println("Processamento finalizado");
        }
    }

}
