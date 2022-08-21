package br.edu.infnet.appos;

import br.edu.infnet.appos.model.domain.OrdemServico;
import br.edu.infnet.appos.model.domain.Solicitante;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class OrdemServicoTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        OrdemServico os = new OrdemServico(new Solicitante("Luna", "31999999999", true));
        os.setDescricao("Lavagem");
        os.setGarantia(false);

        OrdemServico os2 = new OrdemServico(new Solicitante("Tiago", "71999999999", false));
        os2.setDescricao("Reparo no ar condicionado");
        os2.setGarantia(true);

        OrdemServico os3 = new OrdemServico(new Solicitante("Paulo", "51999999999", true));
        os3.setDescricao("Limpeza na cabine");
        os3.setGarantia(false);

        System.out.println(os);
        System.out.println(os2);
        System.out.println(os3);
    }
}
