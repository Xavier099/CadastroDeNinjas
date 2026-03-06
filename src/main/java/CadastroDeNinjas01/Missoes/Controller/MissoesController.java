package CadastroDeNinjas01.Missoes.Controller;

import CadastroDeNinjas01.Missoes.DTO.MissoesDTO;
import CadastroDeNinjas01.Missoes.Service.MissoesService;
import CadastroDeNinjas01.User.DTO.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/missoes")
    public String missoes(){
        return "bem vindo a pagina de missoes";
    }

    @GetMapping("/listMissoes")
    public ResponseEntity<List<MissoesDTO>>  list(){
        List<MissoesDTO> missoes = missoesService.listMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listMissoesId/{id}")
    public ResponseEntity<?> missoesId(@PathVariable Long id){
        MissoesDTO missoesId = missoesService.listMissoesByid(id);
        if(missoesId != null){
            return ResponseEntity.ok(missoesId);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Missão com id: " + id + " nao entrado");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody MissoesDTO missoes){
        MissoesDTO missoesDto = missoesService.creatMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso!! " + missoesDto.getNomeMissao() + " id:" + missoesDto.getId());
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        MissoesDTO missoes = missoesService.update(id,missoesDTO);
        if(missoes != null){
            return ResponseEntity.ok(missoes);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com id: " + id + " nao encontrada");
        }
    }
}
