package CadastroDeNinjas01.User.Model;

import CadastroDeNinjas01.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "email", unique = true)
    private String email;
    @Column (name = "idade")
    private int idade;

    // @ManyToOne - Um Ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "ninja")
    private MissoesModel missoes;
}
