package br.com.biblioteca.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    EM_ANALISE("Em an�lise"),
    ANALISE_REALIZADA("An�lise realizada"),
    ANALISE_APROVADA("An�lise aprovada"),
    INICIADO("Iniciado"),
    PLANEJADO("Planejado"),
    EM_ANDAMENTO("Em andamento"),
    ENCERRADO("Encerrado"),
    CANCELADO("Cancelado") ;

    private String label;

    @JsonValue
    public String toValue() {
        return label;
    }
}
