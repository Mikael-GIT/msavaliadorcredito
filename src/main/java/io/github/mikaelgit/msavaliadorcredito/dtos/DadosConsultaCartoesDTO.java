package io.github.mikaelgit.msavaliadorcredito.dtos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DadosConsultaCartoesDTO {
    
    private DadosClienteDTO dadosCliente;

    private List<DadosCartaoDTO> cartoes;
}