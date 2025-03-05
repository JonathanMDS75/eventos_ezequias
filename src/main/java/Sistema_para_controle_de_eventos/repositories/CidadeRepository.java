package Sistema_para_controle_de_eventos.repositories;

import Sistema_para_controle_de_eventos.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
