package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Solicitante;
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

    public void delete(Integer id) {
        caminhaoRepository.deleteById(id);
    }

    public void add(HttpServletRequest request) {
        Caminhao caminhao = new Caminhao();
        caminhao.setMarca(request.getParameter("marca"));
        caminhao.setModelo(request.getParameter("modelo"));
        caminhao.setAnoFabricacao(Integer.parseInt(request.getParameter("anoFabricacao")));
        caminhao.setTipo(request.getParameter("tipo"));
        caminhao.setCapacidadeCarga(Float.parseFloat(request.getParameter("capacidadeCarga")));
        caminhao.setComprimento(Float.parseFloat(request.getParameter("comprimento")));

        caminhaoRepository.save(caminhao);
    }

    public void add(Caminhao caminhao) {
        caminhaoRepository.save(caminhao);
    }
}
