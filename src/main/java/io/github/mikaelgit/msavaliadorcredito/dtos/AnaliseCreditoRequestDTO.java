package io.github.mikaelgit.msavaliadorcredito.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnaliseCreditoRequestDTO {
    
    private String cpf;

    private Long renda;
}