package io.github.mikaelgit.msavaliadorcredito.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.mikaelgit.msavaliadorcredito.dtos.DadosCartaoDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.DadosClienteDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.SituacaoClienteDTO;
import io.github.mikaelgit.msavaliadorcredito.services.AvaliadorCreditoService;
import io.github.mikaelgit.msavaliadorcredito.services.CartaoService;
import io.github.mikaelgit.msavaliadorcredito.services.ClienteService;

@Service
public class AvaliadorServiceImpl implements AvaliadorCreditoService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CartaoService cartaoService;

    @Override
    public SituacaoClienteDTO obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosClienteDTO> dadosClienteResponse = clienteService.getClienteByCpf(cpf);
        ResponseEntity<List<DadosCartaoDTO>> dadosCartaoResponse = cartaoService.getCartoesByCliente(cpf);
        return SituacaoClienteDTO.builder()
                .dadosCliente(dadosClienteResponse.getBody())
                .cartoes(dadosCartaoResponse.getBody())
                .build();
    }

}