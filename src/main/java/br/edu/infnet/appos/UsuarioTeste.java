package br.edu.infnet.appos;

import br.edu.infnet.appos.exceptions.QuantidadePortasInvalidasException;
import br.edu.infnet.appos.exceptions.UsuarioJaCadastradoException;
import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
@Order(1)
public class UsuarioTeste implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;
    Logger logger = LoggerFactory.getLogger(UsuarioTeste.class);
    @Override
    public void run(ApplicationArguments args) {
        File file = new File("src/main/resources/files/usuarios.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            String[] campos;
            while (linha != null){
                campos = linha.split("\\|");
                Usuario usuario = new Usuario(campos[0], campos[1], campos[2]);
                usuarioService.cadastrar(usuario);
                linha = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException | UsuarioJaCadastradoException e) {
            logger.error(e.getMessage());
        } finally {
            logger.info("Carga do arquivo finalizada");
        }
    }
}
