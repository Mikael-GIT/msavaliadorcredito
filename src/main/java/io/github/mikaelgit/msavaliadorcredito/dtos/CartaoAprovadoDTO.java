package io.github.mikaelgit.msavaliadorcredito.dtos;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartaoAprovadoDTO {
    
    private String cartao;

    private String bandeira;

    private BigDecimal limiteAprovado;
}