package io.github.mikaelgit.msavaliadorcredito.dtos;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DadosCartaoDTO {
    
    private String nome;

    private String bandeira;

    private BigDecimal limiteLiberado;
    
}