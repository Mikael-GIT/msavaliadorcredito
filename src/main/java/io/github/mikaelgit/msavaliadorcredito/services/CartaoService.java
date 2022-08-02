package io.github.mikaelgit.msavaliadorcredito.services;

public interface CartaoService {

    DadosCartaoDTO consultarDadosCartaoPorCliente(String cpf);
    
}