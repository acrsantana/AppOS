package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.domain.Usuario;
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

    public List<Carro> findAll(Usuario usuario) {
        return carroRepository.findCarrosByUsuario(usuario);
    }

    public void delete(Integer id) {
        carroRepository.deleteById(id);
    }

    public void add(Carro carro) {
        carroRepository.save(carro);
    }
}
