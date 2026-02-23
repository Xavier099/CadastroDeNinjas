package CadastroDeNinjas01.Missoes.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/missoes")
    public String missoes(){
        return "bem vindo a pagina de missoes";
    }
}
