package io.github.mikaelgit.msavaliadorcredito.exceptions;

import lombok.Getter;

public class ErroComunicacaoMicroservices extends Exception {

    @Getter
    private int status;

    public ErroComunicacaoMicroservices(String msg, int status){
        super(msg);
        this.status = status;
    }
}
