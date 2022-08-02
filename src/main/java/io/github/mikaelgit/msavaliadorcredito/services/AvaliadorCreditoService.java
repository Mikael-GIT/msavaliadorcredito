package io.github.mikaelgit.msavaliadorcredito.services;

import io.github.mikaelgit.msavaliadorcredito.dtos.DadosConsultaCartoesDTO;

public interface AvaliadorCreditoService {

    DadosConsultaCartoesDTO obterSituacaoCliente(String cpf);
    
}