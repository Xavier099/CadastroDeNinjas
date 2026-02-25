package CadastroDeNinjas01.User.DTO;

import CadastroDeNinjas01.Missoes.Model.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;
    private String name;
    private String email;
    private int idade;
    private MissoesModel missoes;
}
