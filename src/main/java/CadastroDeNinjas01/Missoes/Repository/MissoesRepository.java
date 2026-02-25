package CadastroDeNinjas01.Missoes.Repository;

import CadastroDeNinjas01.Missoes.Model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
