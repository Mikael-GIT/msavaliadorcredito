package io.github.mikaelgit.msavaliadorcredito.services;

import io.github.mikaelgit.msavaliadorcredito.dtos.DadosClienteDTO;

public interface ClienteService {
    
    DadosClienteDTO consultarDadosCliente(String cpf);
    
}