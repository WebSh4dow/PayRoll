package com.Jarmison.Desafio.Npi.Tecnologia.Entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Dependente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome Não informado, porfavor insira o seu nome!")
    @Size(min = 5, max = 50)
    private String nome;

    @Column(nullable = false)
    @Range(min = 0)
    private int idade;
}
