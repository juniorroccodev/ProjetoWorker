package com.wolkersomar.models;

import lombok.Getter;

@Getter
public enum Status {

    PENDENTE (1, "PENDENTE"),
    PROCESSANDO (2, "PROCESSANDO"),
    PROCESSADO (3, "PROCESSADO");

    private Integer cod;
    private String descricao;

    private Status(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    //Retorna um Enum de acordo com o código informado
    public static Status toEnum (Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (Status p : Status.values()) {
            if (codigo.equals(p.getCod())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }

}
