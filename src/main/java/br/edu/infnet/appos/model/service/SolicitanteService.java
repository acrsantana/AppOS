package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitanteService {

    @Autowired
    SolicitanteRepository solicitanteRepository;
    public List<Solicitante> findAll() {
        return solicitanteRepository.findAll();
    }

    public void delete(Integer id) {
        solicitanteRepository.deleteById(id);
    }

    public void add(Solicitante solicitante) {
        solicitanteRepository.save(solicitante);
    }

    public void cadastrar(Solicitante solicitante) {
        solicitanteRepository.save(solicitante);
    }
}
