package CadastroDeNinjas01.Missoes.Service;

import CadastroDeNinjas01.Missoes.DTO.MissoesDTO;
import CadastroDeNinjas01.Missoes.DTO.MissoesMapper;
import CadastroDeNinjas01.Missoes.Repository.MissoesRepository;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //listMissoes
    public List<MissoesDTO> listMissoes(){
        return missoesRepository.findAll()
                .stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }
}
