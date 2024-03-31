package br.com.biblioteca.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {
    EM_ANALISE("Em an�lise"),
    ANALISE_REALIZADA("An�lise realizada"),
    ANALISE_APROVADA("An�lise aprovada"),
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
