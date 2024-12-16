package com.example.pa.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoConsulta {
    PENDIENTE,
    EN_PROCESO,
    RESUELTA;

    @JsonCreator
    public static EstadoConsulta forValue(String value) {
        return EstadoConsulta.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
