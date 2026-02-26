package CadastroDeNinjas01.User.Service;

import CadastroDeNinjas01.User.DTO.NinjaDTO;
import CadastroDeNinjas01.User.DTO.NinjaMapper;
import CadastroDeNinjas01.User.Model.NinjaModel;
import CadastroDeNinjas01.User.Respository.NinjaRepository;
import org.springframework.stereotype.Service;

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
}
