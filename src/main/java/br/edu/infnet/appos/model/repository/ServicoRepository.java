package br.edu.infnet.appos.model.repository;

import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.domain.Servico;
import br.edu.infnet.appos.model.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    List<Servico> findServicosByUsuario(Usuario usuario);

}
