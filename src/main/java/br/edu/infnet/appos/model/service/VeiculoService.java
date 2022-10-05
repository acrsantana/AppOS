package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.domain.Veiculo;
import br.edu.infnet.appos.model.repository.CaminhaoRepository;
import br.edu.infnet.appos.model.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired VeiculoRepository veiculoRepository;
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }
    public List<Veiculo> findAll(Usuario usuario) {
        return veiculoRepository.findAllByUsuario(usuario);
    }

    public void delete(Integer id) {
        veiculoRepository.deleteById(id);
    }

    public HashSet buscaCombo() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        HashSet<String> combo = new HashSet<>();
        veiculos.forEach(veiculo -> combo.add(veiculo.getModelo()));
        return combo;
    }
}
