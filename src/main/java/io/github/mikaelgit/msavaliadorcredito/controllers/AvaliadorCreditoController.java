package io.github.mikaelgit.msavaliadorcredito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.mikaelgit.msavaliadorcredito.dtos.AnaliseCreditoRequestDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.CartaoAprovadoDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.Cliente;
import io.github.mikaelgit.msavaliadorcredito.dtos.RetornoAvaliacaoCreditoDTO;
import io.github.mikaelgit.msavaliadorcredito.exceptions.DadosClienteNotFoundException;
import io.github.mikaelgit.msavaliadorcredito.exceptions.ErroComunicacaoMicroservices;
import io.github.mikaelgit.msavaliadorcredito.services.AvaliadorCreditoService;

@RestController
@RequestMapping("/avaliacoes-credito")
public class AvaliadorCreditoController {
    
    @Autowired
    private AvaliadorCreditoService avaliadorCreditoService;


    @GetMapping
    public String status(){
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity analisarCliente(@RequestParam("cpf") String cpf) throws DadosClienteNotFoundException {
        return ResponseEntity.ok(avaliadorCreditoService.obterSituacaoCliente(cpf));
    }

    @PostMapping
    public ResponseEntity realizarAvaliacaoCreditoCliente(@RequestBody AnaliseCreditoRequestDTO request){
        RetornoAvaliacaoCreditoDTO cartoesAprovados = avaliadorCreditoService.realizarAvaliacao(request.getCpf(), request.getRenda()); 
        return ResponseEntity.ok(cartoesAprovados);
    }
}