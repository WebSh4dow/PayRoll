package com.Jarmison.Desafio.Npi.Tecnologia.Controller;

import com.Jarmison.Desafio.Npi.Tecnologia.DTO.DependenteDTO;
import com.Jarmison.Desafio.Npi.Tecnologia.Service.DependenteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dependentes")
@CrossOrigin("http://localhost:4200")
public class ControllerDependente {
    @Autowired
    private DependenteServico dependenteServico;

    @GetMapping
    public List <DependenteDTO>listar_Todos(){
        return dependenteServico.listar_Dependentes();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DependenteDTO criarDependente(@RequestBody DependenteDTO dependenteDTO){
        return dependenteServico.adcionarDependente(dependenteDTO);
    }
    @GetMapping(value = "/{dependentesid}")
    public DependenteDTO buscar_Dependentes_Por_id(@PathVariable ("dependentesid") Long id){
        return dependenteServico.findByid(id);
    }
    @DeleteMapping(value = "/{dependentesid}")
    public DependenteDTO remover_Dependentes_Por_id(@PathVariable("dependentesid")Long id, @RequestBody DependenteDTO dependenteDTO){
        return dependenteServico.remover(id,dependenteDTO);
    }
    @PutMapping(value = "/{dependentesid}")
    public DependenteDTO atualizar_Dependentes_Por_id(@PathVariable("dependentesid")Long id, @RequestBody DependenteDTO dependenteDTO){
        return dependenteServico.atualizar(id,dependenteDTO);
    }
}
