package br.com.biblioteca.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RiscoEnum {
    BAIXO("Risco baixo"),
    MEDIO("Risco médio"),
    ALTO("Risco alto");

    private String name;

    RiscoEnum(String nameStr) {
        this.name = nameStr;
    }
    @JsonValue
    public String getName() {
        return name;
    }
}
