package com.Jarmison.Desafio.Npi.Tecnologia.Controller;

import com.Jarmison.Desafio.Npi.Tecnologia.DTO.SocioDTO;
import com.Jarmison.Desafio.Npi.Tecnologia.Service.SocioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/socios")
public class ControllerSocio {
    @Autowired
    private SocioServico socioServico;
    @GetMapping
    public List<SocioDTO> listar_Todos(){
        return socioServico.listar_Socios();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SocioDTO criarSocio(@RequestBody SocioDTO socioDTO){
        return socioServico.adcionarSocio(socioDTO);
    }
    @GetMapping(value = "/{sociosid}")
    public SocioDTO buscar_Socio_Por_id(@PathVariable ("sociosid") Long id){
        return socioServico.findByid(id);
    }
    @DeleteMapping(value = "/{sociosid}")
    public SocioDTO remover_Socio_Por_id(@PathVariable("sociosid")Long id, @RequestBody SocioDTO socioDTO){
        return socioServico.remover(id,socioDTO);
    }
    @PutMapping(value = "/{sociosid}")
    public SocioDTO atualizar_Socio_Por_id(@PathVariable("sociosid")Long id, @RequestBody SocioDTO socioDTO){
        return socioServico.atualizar(id,socioDTO);
    }
}
