package io.github.mikaelgit.msavaliadorcredito.services;

import io.github.mikaelgit.msavaliadorcredito.dtos.DadosCartaoDTO;

public interface CartaoService {

    DadosCartaoDTO consultarDadosCartaoPorCliente(String cpf);
    
}