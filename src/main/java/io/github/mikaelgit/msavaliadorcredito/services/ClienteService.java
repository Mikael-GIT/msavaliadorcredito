package io.github.mikaelgit.msavaliadorcredito.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.mikaelgit.msavaliadorcredito.dtos.Cliente;

@FeignClient(value = "msclientes", path = "/clientes")
public interface ClienteService {
    
    @GetMapping(params = "cpf")
    ResponseEntity<Cliente> getClienteByCpf(@RequestParam("cpf") String cpf);
    
}