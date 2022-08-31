package io.github.mikaelgit.msavaliadorcredito.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RetornoAvaliacaoCreditoDTO {

    private List<CartaoAprovadoDTO> cartoes;
}