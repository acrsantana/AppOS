package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CaminhaoService {

    @Autowired CaminhaoRepository caminhaoRepository;
    public List<Caminhao> findAll() {
        return caminhaoRepository.findAll();
    }

    public List<Caminhao> findAll(Usuario usuario) {
        return caminhaoRepository.findAllByUsuario(usuario);
    }

    public void delete(Integer id) {
        caminhaoRepository.deleteById(id);
    }

    public Caminhao add(Caminhao caminhao) {
        return caminhaoRepository.save(caminhao);
    }
}
