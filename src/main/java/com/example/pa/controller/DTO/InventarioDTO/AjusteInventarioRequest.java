package com.example.pa.controller.DTO.InventarioDTO;

import jakarta.validation.constraints.NotNull;

public class AjusteInventarioRequest {

    @NotNull
    private Long productoId;

    @NotNull
    private Integer cantidadAjustada;

    @NotNull
    private String razonAjuste;

    // Getters y setters
    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidadAjustada() {
        return cantidadAjustada;
    }

    public void setCantidadAjustada(Integer cantidadAjustada) {
        this.cantidadAjustada = cantidadAjustada;
    }

    public String getRazonAjuste() {
        return razonAjuste;
    }

    public void setRazonAjuste(String razonAjuste) {
        this.razonAjuste = razonAjuste;
    }
}