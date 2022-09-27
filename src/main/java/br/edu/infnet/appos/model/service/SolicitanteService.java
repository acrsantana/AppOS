package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.repository.SolicitanteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitanteService {

    @Autowired
    SolicitanteRepository solicitanteRepository;

    Logger logger = LoggerFactory.getLogger(SolicitanteService.class);
    public List<Solicitante> findAll() {
        logger.info("Buscando solicitantes cadastrados");
        return solicitanteRepository.findAll();
    }

    public void delete(Integer id) {
        logger.info("Removendo solicitante {}", id);
        solicitanteRepository.deleteById(id);
    }

    public void add(Solicitante solicitante) {
        logger.info("Adicionando o solicitante {}", solicitante.getNome());
        solicitanteRepository.save(solicitante);
    }


}
