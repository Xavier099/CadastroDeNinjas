package CadastroDeNinjas01.User.Controller;

import CadastroDeNinjas01.User.DTO.NinjaDTO;
import CadastroDeNinjas01.User.Service.NInjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class NinjaController {

    private NInjaService ninjaService;

    public NinjaController(NInjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/bem-vindo")
    public String bemVindo(){
        return "Ola seja bem vindo ao minha primeira rota";
    }

    @GetMapping("/list")
    public List<NinjaDTO> list(){
        return ninjaService.list();
    }

    @GetMapping("/listById/{id}")
    public NinjaDTO listByid(@PathVariable Long id){
        return ninjaService.listId(id);
    }

    @PostMapping("/criar")
    public List<NinjaDTO> create(@RequestBody List<NinjaDTO> ninjaDTO){
        return ninjaService.createNinja(ninjaDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarById(@PathVariable Long id){
        ninjaService.deletar(id);
    }
}
