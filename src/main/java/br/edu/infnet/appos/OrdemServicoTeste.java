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
        OrdemServico os = new OrdemServico();
        os.setData(LocalDateTime.now());
        os.setDescricao("Lavagem");
        os.setGarantia(false);
        os.setSolicitante(new Solicitante("Luna", "31999999999", true));

        OrdemServico os2 = new OrdemServico();
        os2.setData(LocalDateTime.now());
        os2.setDescricao("Reparo no ar condicionado");
        os2.setGarantia(true);
        os2.setSolicitante(new Solicitante("Tiago", "71999999999", false));

        OrdemServico os3 = new OrdemServico();
        os3.setData(LocalDateTime.now());
        os3.setDescricao("Limpeza na cabine");
        os3.setGarantia(false);
        os3.setSolicitante(new Solicitante("Paulo", "51999999999", true));

        System.out.println(os);
        System.out.println(os2);
        System.out.println(os3);
    }
}
