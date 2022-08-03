package io.github.mikaelgit.msavaliadorcredito.exceptions;

import java.time.Instant;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StandardError {
    
    private Instant timestamp;

    private Integer status;

    private String mensagem;

}