package com.Jarmison.Desafio.Npi.Tecnologia.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome Não informado, porfavor insira o seu nome!")
    @Size(min = 5, max = 50)
    private String nome;

    @Column(nullable = false)
    private BigDecimal renda;

    @Column(nullable = false)
    private Boolean ativo;

}
