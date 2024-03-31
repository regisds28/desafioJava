package br.com.biblioteca.model;

import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name="tb_projetos")
public class Projeto {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
