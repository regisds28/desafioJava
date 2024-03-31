package br.com.biblioteca.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MembroDTO {
    @NotNull
    private String nomeMembro;
    @NotNull
    private String cargo;
}
