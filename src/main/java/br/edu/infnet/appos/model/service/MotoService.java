package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.exceptions.VeiculoEmUsoException;
import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.domain.Moto;
import br.edu.infnet.appos.model.domain.Usuario;
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

    public List<Moto> findAll(Usuario usuario) {
        return motoRepository.findMotosByUsuario(usuario);
    }
    public void delete(Integer id) throws VeiculoEmUsoException {
        try {
            motoRepository.deleteById(id);
        } catch (Exception e){
            throw new VeiculoEmUsoException("Não é possível excluir a moto pois a mesma está em uso");
        }

    }

    public Moto add(Moto moto) {
        return motoRepository.save(moto);
    }
}
