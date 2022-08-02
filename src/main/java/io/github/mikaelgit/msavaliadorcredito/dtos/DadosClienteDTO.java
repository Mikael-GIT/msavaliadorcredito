package io.github.mikaelgit.msavaliadorcredito.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DadosClienteDTO {
    
    private Long id;

    private String cpf;

    private String nome;

    private Integer idade;
}