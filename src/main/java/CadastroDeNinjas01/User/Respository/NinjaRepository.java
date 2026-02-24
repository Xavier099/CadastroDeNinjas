package CadastroDeNinjas01.User.Respository;

import CadastroDeNinjas01.User.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
