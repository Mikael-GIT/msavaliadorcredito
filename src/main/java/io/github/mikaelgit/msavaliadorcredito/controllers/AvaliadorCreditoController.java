package io.github.mikaelgit.msavaliadorcredito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.mikaelgit.msavaliadorcredito.dtos.DadosConsultaCartoesDTO;
import io.github.mikaelgit.msavaliadorcredito.services.AvaliadorCreditoService;

@RestController
@RequestMapping("/avaliacoes-credito")
public class AvaliadorCreditoController {
    
    @Autowired
    private AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping(value = "situacao-cliente" ,params = "cpf")
    public DadosConsultaCartoesDTO analisarCliente(@RequestParam("cpf") String cpf) {
        return avaliadorCreditoService.obterSituacaoCliente(cpf);
    }
}