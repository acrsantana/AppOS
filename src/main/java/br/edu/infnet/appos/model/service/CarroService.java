package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CarroService {

    @Autowired CarroRepository carroRepository;
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    public void delete(Integer id) {
        carroRepository.deleteById(id);
    }

    public void add(HttpServletRequest request) {
        Carro carro = new Carro();
        carro.setMarca(request.getParameter("marca"));
        carro.setModelo(request.getParameter("modelo"));
        carro.setAnoFabricacao(Integer.parseInt(request.getParameter("anoFabricacao")));
        carro.setTipo(request.getParameter("tipo"));
        carro.setArCondicionado((request.getParameter("arCondicionado") == "Sim") ? true : false);
        carro.setPortas(Integer.parseInt(request.getParameter("portas")));

        carroRepository.save(carro);
    }

    public void add(Carro carro) {
        carroRepository.save(carro);
    }
}
