package com.Jarmison.Desafio.Npi.Tecnologia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SocioDTO {
    private Long id;
    private String nome;
    private BigDecimal renda;
    private Boolean ativo;
}
