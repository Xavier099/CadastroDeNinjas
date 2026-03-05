package CadastroDeNinjas01.Missoes.Controller;

import CadastroDeNinjas01.Missoes.DTO.MissoesDTO;
import CadastroDeNinjas01.Missoes.Service.MissoesService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/listMissoes")
    public List<MissoesDTO> listMissoes(){
        return missoesService.listMissoes();
    }

    @GetMapping("/listMissoesId/{id}")
    public MissoesDTO missoesId(@PathVariable Long id){
        return missoesService.listMissoesByid(id);
    }

    @PatchMapping("/update/{id}")
    public MissoesDTO update(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        return missoesService.update(id,missoesDTO);
    }
}
