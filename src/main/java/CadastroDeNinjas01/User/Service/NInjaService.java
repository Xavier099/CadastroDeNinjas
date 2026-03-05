package CadastroDeNinjas01.User.Service;

import CadastroDeNinjas01.User.DTO.NinjaDTO;
import CadastroDeNinjas01.User.DTO.NinjaMapper;
import CadastroDeNinjas01.User.Model.NinjaModel;
import CadastroDeNinjas01.User.Respository.NinjaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NInjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NInjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //create ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTOS){
       NinjaModel ninja = ninjaMapper.map(ninjaDTOS);
       ninja = ninjaRepository.save(ninja);
       return ninjaMapper.map(ninja);
    }

    //list ninjas
    public List<NinjaDTO> list(){
        return ninjaRepository.findAll()
                .stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //list by id
    public NinjaDTO listId(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    //delete
    public void deletar(Long id){
        ninjaRepository.deleteById(id);
    }

    //update
    public NinjaDTO update(Long id, NinjaDTO ninjaDTO){
        //procura o id
       Optional<NinjaModel> ninjaUpdate = ninjaRepository.findById(id);
       //se for presente este id
       if (ninjaUpdate.isPresent()){
           NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
           ninjaAtualizado.setId(id);
           NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
           return ninjaMapper.map(ninjaSalvo);
       }
       return null;
    }
}
