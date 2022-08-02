package io.github.mikaelgit.msavaliadorcredito.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.mikaelgit.msavaliadorcredito.dtos.DadosClienteDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.SituacaoClienteDTO;
import io.github.mikaelgit.msavaliadorcredito.services.AvaliadorCreditoService;
import io.github.mikaelgit.msavaliadorcredito.services.ClienteService;

@Service 
public class AvaliadorServiceImpl implements AvaliadorCreditoService {

    @Autowired
    private ClienteService clienteService;

    @Override
    public SituacaoClienteDTO obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosClienteDTO> dadosClienteResponse = clienteService.getClienteByCpf(cpf);

        return SituacaoClienteDTO.builder().dadosCliente(dadosClienteResponse.getBody()).build();
    }

}