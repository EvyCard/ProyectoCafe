package com.example.proyecto_cafe.controllers;

public class Pantalla_4_class {

    private int pesoCafe;
    private int pesoCafeTostado;
    private int pesoHidrolosis;
    private int pesoExtracto;
    private int pesoConcentrado;
    private int pesoCafeSoluble;
    private String color;


    public Pantalla_4_class(int pesoCafe, int pesoCafeTostado, int pesoHidrolosis, int pesoExtracto, int pesoConcentrado, int pesoCafeSoluble, String color) {
        this.setPesoCafe(pesoCafe);
        this.setPesoCafeTostado(pesoCafeTostado);
        this.setPesoHidrolosis(pesoHidrolosis);
        this.setPesoExtracto(pesoExtracto);
        this.setPesoConcentrado(pesoConcentrado);
        this.setPesoCafeSoluble(pesoCafeSoluble);
        this.setColor(color);
    }


    public int getPesoCafe() {
        return pesoCafe;
    }

    public void setPesoCafe(int pesoCafe) {
        this.pesoCafe = pesoCafe;
    }

    public int getPesoCafeTostado() {
        return pesoCafeTostado;
    }

    public void setPesoCafeTostado(int pesoCafeTostado) {
        this.pesoCafeTostado = pesoCafeTostado;
    }

    public int getPesoHidrolosis() {
        return pesoHidrolosis;
    }

    public void setPesoHidrolosis(int pesoHidrolosis) {
        this.pesoHidrolosis = pesoHidrolosis;
    }

    public int getPesoExtracto() {
        return pesoExtracto;
    }

    public void setPesoExtracto(int pesoExtracto) {
        this.pesoExtracto = pesoExtracto;
    }

    public int getPesoConcentrado() {
        return pesoConcentrado;
    }

    public void setPesoConcentrado(int pesoConcentrado) {
        this.pesoConcentrado = pesoConcentrado;
    }

    public int getPesoCafeSoluble() {
        return pesoCafeSoluble;
    }

    public void setPesoCafeSoluble(int pesoCafeSoluble) {
        this.pesoCafeSoluble = pesoCafeSoluble;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
