package io.github.mikaelgit.msavaliadorcredito.services;

import io.github.mikaelgit.msavaliadorcredito.dtos.SituacaoClienteDTO;

public interface AvaliadorCreditoService {

    SituacaoClienteDTO obterSituacaoCliente(String cpf);
    
}