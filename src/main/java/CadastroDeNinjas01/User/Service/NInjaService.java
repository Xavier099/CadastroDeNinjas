package CadastroDeNinjas01.User.Service;

import CadastroDeNinjas01.User.DTO.NinjaDTO;
import CadastroDeNinjas01.User.DTO.NinjaMapper;
import CadastroDeNinjas01.User.Model.NinjaModel;
import CadastroDeNinjas01.User.Respository.NinjaRepository;
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
    public List<NinjaDTO> createNinja(List<NinjaDTO> ninjaDTOS){
        // lista de ninja model recebe uma stream do ninjaDTOS que é mapeada
        List<NinjaModel> ninja = ninjaDTOS.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
        //salva os novos usuarios
        List<NinjaModel> ninjaModels = ninjaRepository.saveAll(ninja);

        //retorna novamente para o formato de lista
        return ninjaModels.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
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
        if(ninjaRepository.existsById(id)){
            ninjaDTO.setId(id);
            return ninjaRepository.save(ninjaDTO);
        }
        return null;
    }
}
