package io.github.mikaelgit.msavaliadorcredito.services;

import io.github.mikaelgit.msavaliadorcredito.dtos.AnaliseCreditoRequestDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.RetornoAvaliacaoCreditoDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.SituacaoClienteDTO;
import io.github.mikaelgit.msavaliadorcredito.exceptions.DadosClienteNotFoundException;

public interface AvaliadorCreditoService {

    SituacaoClienteDTO obterSituacaoCliente(String cpf) throws DadosClienteNotFoundException;

    RetornoAvaliacaoCreditoDTO realizarAvaliacao(String cpf, Long renda);
}