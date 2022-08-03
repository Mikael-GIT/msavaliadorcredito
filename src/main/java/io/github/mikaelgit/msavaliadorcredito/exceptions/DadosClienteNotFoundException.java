package io.github.mikaelgit.msavaliadorcredito.exceptions;

public class DadosClienteNotFoundException extends Exception {
    public DadosClienteNotFoundException(){
        super("Dados não encontrados para o cpf informado.");
    }
}