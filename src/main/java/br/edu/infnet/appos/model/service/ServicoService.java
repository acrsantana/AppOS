package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.domain.Servico;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired ServicoRepository servicoRepository;
    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

//    public List<Servico> findAll(Usuario usuario) {
//        return servicoRepository.findServicosByUsuario(usuario);
//    }

    public void delete(Integer id) {
        servicoRepository.deleteById(id);
    }

    public Servico add(Servico servico) {
        return servicoRepository.save(servico);
    }
}
