package CadastroDeNinjas01.Missoes.Controller;

import CadastroDeNinjas01.Missoes.DTO.MissoesDTO;
import CadastroDeNinjas01.Missoes.Service.MissoesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/missoes")
    public String missoes(){
        return "bem vindo a pagina de missoes";
    }

    @GetMapping("/list")
    public List<MissoesDTO> listMissoes(){
        return missoesService.listMissoes();
    }
}
