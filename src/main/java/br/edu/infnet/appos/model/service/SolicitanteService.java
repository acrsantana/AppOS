package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.repository.SolicitanteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class SolicitanteService {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    Logger logger = LoggerFactory.getLogger(SolicitanteService.class);
    public List<Solicitante> findAll() {
        logger.debug("Buscando solicitantes cadastrados");
        return solicitanteRepository.findAll();
    }

    public List<Solicitante> findAll(Usuario usuario) {
        logger.debug("Buscando solicitantes cadastrados");
        return solicitanteRepository.findSolicitanteByUsuario(usuario);
    }

    public void delete(Integer id) {
        logger.debug("Removendo solicitante {}", id);
        solicitanteRepository.deleteById(id);
    }

    public Solicitante add(Solicitante solicitante) {
        logger.debug("Adicionando o solicitante {}", solicitante.getNome());
        return solicitanteRepository.save(solicitante);
    }

    public HashSet<String> buscaCombo() {
        List<Solicitante> solicitantes = solicitanteRepository.findAll();
        HashSet<String> combo = new HashSet<String>();
        solicitantes.forEach(solicitante -> combo.add(solicitante.getNome()));
        return combo;
    }
}
