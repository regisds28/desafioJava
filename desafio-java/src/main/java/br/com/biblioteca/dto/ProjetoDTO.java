package br.com.biblioteca.dto;

import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ProjetoDTO {

    @NotNull
    private String nome;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataInicio;
    private String gerente;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate previsaoTermino;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataRealTermino;
    private float orcamento;
    private String descricao;
    private RiscoEnum risco;
    private StatusEnum status;


}
