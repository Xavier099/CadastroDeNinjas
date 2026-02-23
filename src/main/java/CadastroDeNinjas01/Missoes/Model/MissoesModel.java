package CadastroDeNinjas01.Missoes.Model;

import CadastroDeNinjas01.User.Model.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nome_missao")
    private String nomeMissao;
    @Column (name = "dificuldade")
    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninja;

}
