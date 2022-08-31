package io.github.mikaelgit.msavaliadorcredito.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.mikaelgit.msavaliadorcredito.dtos.AnaliseCreditoRequestDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.CartaoAprovadoDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.CartaoDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.DadosCartaoDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.Cliente;
import io.github.mikaelgit.msavaliadorcredito.dtos.RetornoAvaliacaoCreditoDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.SituacaoClienteDTO;
import io.github.mikaelgit.msavaliadorcredito.exceptions.DadosClienteNotFoundException;
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
    public SituacaoClienteDTO obterSituacaoCliente(String cpf) throws DadosClienteNotFoundException {
        ResponseEntity<Cliente> dadosClienteResponse = clienteService.getClienteByCpf(cpf);
        ResponseEntity<List<DadosCartaoDTO>> dadosCartaoResponse = cartaoService.getCartoesByCliente(cpf);
        return SituacaoClienteDTO.builder()
                .dadosCliente(dadosClienteResponse.getBody())
                .cartoes(dadosCartaoResponse.getBody())
                .build();
    }

    @Override
    public RetornoAvaliacaoCreditoDTO realizarAvaliacao(String cpf, Long renda) {
        ResponseEntity<Cliente> dadosClienteResponse = clienteService.getClienteByCpf(cpf);
        ResponseEntity<List<CartaoDTO>> cartoesResponse = cartaoService.getCartoesByRenda(renda);

        List<CartaoDTO> cartoes = cartoesResponse.getBody();

        List<CartaoAprovadoDTO> cartoesAprovados = cartoes.stream().map(cartao -> {
            Cliente dadosCliente = dadosClienteResponse.getBody();
            BigDecimal limiteBasico = cartao.getLimiteBasico(); 
            BigDecimal idadeBD = BigDecimal.valueOf(dadosCliente.getIdade()); 
            var fator = idadeBD.divide(BigDecimal.valueOf(10));
            BigDecimal limiteAprovado = fator.multiply(limiteBasico); 

            CartaoAprovadoDTO cartaoAprovado = new CartaoAprovadoDTO();

            cartaoAprovado.setCartao(cartao.getNome());
            cartaoAprovado.setBandeira(cartao.getBandeira());
            cartaoAprovado.setLimiteAprovado(limiteAprovado);
            return cartaoAprovado;
        }).collect(Collectors.toList());
        return new RetornoAvaliacaoCreditoDTO(cartoesAprovados);
    }
}