package br.com.biblioteca.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RiscoEnum {
    BAIXO("Risco baixo"),
    MEDIO("Risco m�dio"),
    ALTO("Risco alto");

    private String label;

    @JsonValue
    public String toValue() {
        return label;
    }
}
