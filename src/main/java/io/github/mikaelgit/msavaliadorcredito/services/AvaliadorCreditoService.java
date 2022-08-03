package io.github.mikaelgit.msavaliadorcredito.services;

import io.github.mikaelgit.msavaliadorcredito.dtos.SituacaoClienteDTO;
import io.github.mikaelgit.msavaliadorcredito.exceptions.DadosClienteNotFoundException;

public interface AvaliadorCreditoService {

    SituacaoClienteDTO obterSituacaoCliente(String cpf) throws DadosClienteNotFoundException;
    
}