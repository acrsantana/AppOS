package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.exceptions.VeiculoEmUsoException;
import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.repository.CarroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    Logger logger = LoggerFactory.getLogger(CarroService.class);
    @Autowired CarroRepository carroRepository;
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    public List<Carro> findAll(Usuario usuario) {
        return carroRepository.findCarrosByUsuario(usuario);
    }

    public void delete(Integer id) throws VeiculoEmUsoException {
        try {
            carroRepository.deleteById(id);
        } catch (Exception e){
            throw new VeiculoEmUsoException("Não é possível excluir o carro pois o mesmo está em uso");
        }

    }

    public Carro add(Carro carro) {
        return carroRepository.save(carro);
    }
}
