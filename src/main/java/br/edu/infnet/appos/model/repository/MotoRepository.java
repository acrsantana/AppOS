package br.edu.infnet.appos.model.repository;

import br.edu.infnet.appos.model.domain.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer> {

}
