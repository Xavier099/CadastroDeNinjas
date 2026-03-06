package CadastroDeNinjas01.User.Controller;

import CadastroDeNinjas01.User.DTO.NinjaDTO;
import CadastroDeNinjas01.User.Service.NInjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class NinjaController {

    private final NInjaService ninjaService;

    public NinjaController(NInjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/bem-vindo")
    public String bemVindo(){
        return "Ola seja bem vindo ao minha primeira rota";
    }

    @GetMapping("/list")
    public ResponseEntity<List<NinjaDTO>> list(){
        List<NinjaDTO> ninjas = ninjaService.list();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listById/{id}")
    public ResponseEntity<?> listByid(@PathVariable Long id){
        NinjaDTO listarPorId = ninjaService.listId(id);
        if( listarPorId != null){
            return ResponseEntity.ok(listarPorId);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ninja com id: " + id + " nao encontrado");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> create(@RequestBody NinjaDTO ninjaDTO){
        NinjaDTO ninjaDTO1 = ninjaService.createNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso" + ninjaDTO1.getName() + " (ID): " + ninjaDTO1.getId());

    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody NinjaDTO ninjaDTO){
       NinjaDTO ninjaUpdate = ninjaService.update(id, ninjaDTO);
       if(ninjaUpdate != null){
           return ResponseEntity.ok(ninjaUpdate);
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Ninja com id: " + id + " não encontrado");
       }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarById(@PathVariable Long id){
        if(ninjaService.listId(id) != null){
            ninjaService.deletar(id);
            return ResponseEntity.ok("Ninja com id: " + id + ",deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: " + id + " não encontrado");
        }
    }
}
