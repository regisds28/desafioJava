package br.com.biblioteca.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {
    EM_ANALISE("Em análise"),
    ANALISE_REALIZADA("Análise realizada"),
    ANALISE_APROVADA("Análise aprovada"),
    INICIADO("Iniciado"),
    PLANEJADO("Planejado"),
    EM_ANDAMENTO("Em andamento"),
    ENCERRADO("Encerrado"),
    CANCELADO("Cancelado") ;

    private String name;

    StatusEnum(String nameStr) {
        this.name = nameStr;
    }
    @JsonValue
    public String getName() {
        return name;
    }
}
