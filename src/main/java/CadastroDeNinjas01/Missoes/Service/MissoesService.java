package CadastroDeNinjas01.Missoes.Service;

import CadastroDeNinjas01.Missoes.DTO.MissoesDTO;
import CadastroDeNinjas01.Missoes.DTO.MissoesMapper;
import CadastroDeNinjas01.Missoes.Model.MissoesModel;
import CadastroDeNinjas01.Missoes.Repository.MissoesRepository;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    //listMissoes por id
    public MissoesDTO listMissoesByid(Long id){
        Optional<MissoesModel> missoes = missoesRepository.findById(id);
        return missoes.map(missoesMapper::map).orElse(null);
    }

    //create missoes
    public MissoesDTO creatMissoes(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }
    //update
    public MissoesDTO update(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missoesUpdate = missoesRepository.findById(id);
        if(missoesUpdate.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
    //delete missoes
    public void deleteMissoes(Long id){
        missoesRepository.deleteById(id);
    }
}
