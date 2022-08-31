package io.github.mikaelgit.msavaliadorcredito.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.mikaelgit.msavaliadorcredito.dtos.CartaoDTO;
import io.github.mikaelgit.msavaliadorcredito.dtos.DadosCartaoDTO;

@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartaoService {

    @GetMapping(params = "cpf")
    ResponseEntity<List<DadosCartaoDTO>> getCartoesByCliente(@RequestParam("cpf") String cpf);
    
    @GetMapping(params = "renda")
    ResponseEntity<List<CartaoDTO>> getCartoesByRenda(@RequestParam("renda") Long renda);
}