package io.github.mikaelgit.msavaliadorcredito.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SituacaoClienteDTO {
    
    private Cliente dadosCliente;

    private List<DadosCartaoDTO> cartoes;
}