package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.OrdemServico;
import br.edu.infnet.appos.model.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoService {

    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    public void addOrdemServico(OrdemServico ordemServico) {
        ordemServicoRepository.save(ordemServico);
    }
}
