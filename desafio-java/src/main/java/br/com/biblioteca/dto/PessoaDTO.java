package br.com.biblioteca.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PessoaDTO {
    @NotNull
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private String cpf;
    @NotNull
    private Boolean gerente;
    @NotNull
    private Boolean funcionario;
}
