package br.edu.infnet.appos;

import br.edu.infnet.appos.model.domain.OrdemServico;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class OrdemServicoTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
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
