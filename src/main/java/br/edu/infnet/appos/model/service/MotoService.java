package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.domain.Moto;
import br.edu.infnet.appos.model.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MotoService {

    @Autowired MotoRepository motoRepository;
    public List<Moto> findAll() {
        return motoRepository.findAll();
    }

    public void delete(Integer id) {
        motoRepository.deleteById(id);
    }

    public void add(HttpServletRequest request) {
        Moto moto = new Moto();
        moto.setMarca(request.getParameter("marca"));
        moto.setModelo(request.getParameter("modelo"));
        moto.setAnoFabricacao(Integer.parseInt(request.getParameter("anoFabricacao")));
        moto.setCilindrada(Integer.parseInt(request.getParameter("cilindrada")));
        moto.setEstilo(request.getParameter("estilo"));
        moto.setQuantidadeDePassageiros(Integer.parseInt(request.getParameter("quantidadeDePassageiros")));

        motoRepository.save(moto);
    }

    public void add(Moto moto) {
        motoRepository.save(moto);
    }
}
