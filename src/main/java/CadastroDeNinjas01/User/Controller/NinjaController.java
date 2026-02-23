package CadastroDeNinjas01.User.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class NinjaController {

    @GetMapping("/bem-vindo")
    public String bemVindo(){
        return "Ola seja bem vindo ao minha primeira rota";
    }
}
