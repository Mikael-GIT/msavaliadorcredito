package io.github.mikaelgit.msavaliadorcredito.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.mikaelgit.msavaliadorcredito.dtos.DadosCartaoDTO;

@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartaoService {

    @GetMapping(params = "cpf")
    public ResponseEntity<List<DadosCartaoDTO>> getCartoesByCliente(@RequestParam("cpf") String cpf);
    
}