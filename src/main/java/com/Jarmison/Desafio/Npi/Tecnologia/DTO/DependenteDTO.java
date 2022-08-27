package com.Jarmison.Desafio.Npi.Tecnologia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DependenteDTO {
    private Long id;
    private String nome;
    private int idade;
}
