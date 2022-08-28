package com.Jarmison.Desafio.Npi.Tecnologia.Service;

import com.Jarmison.Desafio.Npi.Tecnologia.DTO.SocioDTO;
import com.Jarmison.Desafio.Npi.Tecnologia.Entity.Socio;
import com.Jarmison.Desafio.Npi.Tecnologia.Exceptions.DependenteException;
import com.Jarmison.Desafio.Npi.Tecnologia.Exceptions.SocioException;
import com.Jarmison.Desafio.Npi.Tecnologia.Repository.SocioRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocioServico {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SocioRepository socioRepository;
    private static final String NOT_FOUND_EXCEPTION_HANDLER = "Não foi possivel encontrar o Socio de id:";
    public SocioDTO convert_Entity_To_Dto(Socio socio) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        SocioDTO socioDTO = new SocioDTO();
        socioDTO = modelMapper.map(socio, SocioDTO.class);
        return socioDTO;

    }
    public Socio convert_Dto_To_Entity(SocioDTO socioDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Socio socio = new Socio();
        socio = modelMapper.map(socioDTO,Socio.class);
        return socio;
    }
    public SocioDTO adcionarSocio (SocioDTO socioDTO){
        Socio socio = convert_Dto_To_Entity(socioDTO);
        Socio criarSocio = socioRepository.save(socio);
        return convert_Entity_To_Dto(criarSocio);
    }
    public List<SocioDTO> listar_Socios(){
        return socioRepository.findAll()
                .stream()
                .map(this::convert_Entity_To_Dto)
                .collect(Collectors.toList());
    }
    public SocioDTO findByid(Long id){
        return socioRepository.findById(id)
                .map(socio -> convert_Entity_To_Dto(socio))
                .orElseThrow(()-> new SocioException(String.format(NOT_FOUND_EXCEPTION_HANDLER)+id));
    }
    public SocioDTO atualizar(Long id, SocioDTO socioDTO){
        return socioRepository.findById(id)
                .map(atualizar_socio -> {
                    Socio socio = convert_Dto_To_Entity(socioDTO);
                    atualizar_socio.setNome(atualizar_socio.getNome());
                    atualizar_socio.setAtivo(atualizar_socio.getAtivo());
                    atualizar_socio.setRenda(atualizar_socio.getRenda());
                    Socio atualizar = socioRepository.save(socio);
                    return convert_Entity_To_Dto(atualizar);

                }).orElseThrow(()-> new DependenteException(String.format(NOT_FOUND_EXCEPTION_HANDLER)+id));
    }
     public ResponseEntity<Object> remover(Long id){
                 return socioRepository.findById(id)
                .map(remover_socio -> {
                    socioRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                } ).orElseThrow(()-> new DependenteException(String.format(NOT_FOUND_EXCEPTION_HANDLER)+id));
    }
}
