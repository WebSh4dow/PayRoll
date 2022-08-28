package com.Jarmison.Desafio.Npi.Tecnologia.Service;

import com.Jarmison.Desafio.Npi.Tecnologia.DTO.DependenteDTO;
import com.Jarmison.Desafio.Npi.Tecnologia.Entity.Dependente;
import com.Jarmison.Desafio.Npi.Tecnologia.Exceptions.DependenteException;
import com.Jarmison.Desafio.Npi.Tecnologia.Repository.DepedenteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DependenteServico {
    @Autowired
    private DepedenteRepository depedenteRepository;
    @Autowired
    private ModelMapper modelMapper;
    private static final String NOT_FOUND_EXCEPTION_HANDLER = "Não foi possivel encontrar o dependente de id:";
    public DependenteDTO convert_Entity_To_Dto(Dependente dependente) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        DependenteDTO dependenteDTO = new DependenteDTO();
        dependenteDTO = modelMapper.map(dependente, DependenteDTO.class);
        return dependenteDTO;

    }
    public Dependente convert_Dto_To_Entity(DependenteDTO dependenteDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Dependente dependente = new Dependente();
        dependente = modelMapper.map(dependenteDTO,Dependente.class);
        return dependente;
    }
    public DependenteDTO adcionarDependente (DependenteDTO dependenteDTO){
        Dependente dependente = convert_Dto_To_Entity(dependenteDTO);
        Dependente criarDependente = depedenteRepository.save(dependente);
        return convert_Entity_To_Dto(criarDependente);
    }
    public List <DependenteDTO> listar_Dependentes(){
        return depedenteRepository.findAll()
                .stream()
                .map(this::convert_Entity_To_Dto)
                .collect(Collectors.toList());
    }
    public DependenteDTO findByid(Long id){
        return depedenteRepository.findById(id)
                .map(dependente -> convert_Entity_To_Dto(dependente))
                .orElseThrow(()-> new DependenteException(String.format(NOT_FOUND_EXCEPTION_HANDLER)+id));
    }

    public DependenteDTO atualizar(Long id, DependenteDTO dependenteDTO){
        return depedenteRepository.findById(id)
                .map(atualizar_dependente -> {
                    Dependente dependente = convert_Dto_To_Entity(dependenteDTO);
                    atualizar_dependente.setNome(atualizar_dependente.getNome());
                    atualizar_dependente.setIdade(atualizar_dependente.getIdade());
                    Dependente atualizar = depedenteRepository.save(dependente);
                    return convert_Entity_To_Dto(atualizar);

                }).orElseThrow(()-> new DependenteException(String.format(NOT_FOUND_EXCEPTION_HANDLER)+id));
    }

    public ResponseEntity<Object> remover(Long id){
                return depedenteRepository.findById(id)
                .map(removeObject -> {
                 depedenteRepository.deleteById(id);
                 return ResponseEntity.noContent().build();
                }).orElseThrow(()-> new DependenteException(String.format(NOT_FOUND_EXCEPTION_HANDLER)+id));
    }
}
