package com.example.proyecto_cafe.controllers;

public class EnvaseEtiquetado {

    private String fechaEnvasado;
    private String cantidadEmpaques;
    private String cantidadCajas;
    private String fechaEtiquetado;
    private String fechaElaboracion;
    private String fechaCaducidad;

    public EnvaseEtiquetado(String fechaEnvasado, String cantidadEmpaques, String cantidadCajas, String fechaEtiquetado, String fechaElaboracion, String fechaCaducidad) {
        this.setFechaEnvasado(fechaEnvasado);
        this.setCantidadEmpaques(cantidadEmpaques);
        this.setCantidadCajas(cantidadCajas);
        this.setFechaEtiquetado(fechaEtiquetado);
        this.setFechaElaboracion(fechaElaboracion);
        this.setFechaCaducidad(fechaCaducidad);
    }


    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public String getCantidadEmpaques() {
        return cantidadEmpaques;
    }

    public void setCantidadEmpaques(String cantidadEmpaques) {
        this.cantidadEmpaques = cantidadEmpaques;
    }

    public String getCantidadCajas() {
        return cantidadCajas;
    }

    public void setCantidadCajas(String cantidadCajas) {
        this.cantidadCajas = cantidadCajas;
    }

    public String getFechaEtiquetado() {
        return fechaEtiquetado;
    }

    public void setFechaEtiquetado(String fechaEtiquetado) {
        this.fechaEtiquetado = fechaEtiquetado;
    }

    public String getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(String fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}
