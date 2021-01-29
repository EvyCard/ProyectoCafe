package com.example.proyecto_cafe;

public class Pantalla_ensayo_class {


    private String categoria;
    private String fechasol;
    private String fechataza;
    private String puntaje;
    private String resultado_final;
    private String tiempo_c;
    private String tiempo_f;
    private String sp_aroma;
    private String sp_sabor;

    public Pantalla_ensayo_class(String categoria, String fechasol, String fechataza, String puntaje, String resultado_final, String tiempo_c, String tiempo_f, String sp_aroma, String sp_sabor) {
        this.setCategoria(categoria);
        this.setFechasol(fechasol);
        this.setFechataza(fechataza);
        this.setPuntaje(puntaje);
        this.setResultado_final(resultado_final);
        this.setTiempo_c(tiempo_c);
        this.setTiempo_f(tiempo_f);
        this.setSp_aroma(sp_aroma);
        this.setSp_sabor(sp_sabor);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechasol() {
        return fechasol;
    }

    public void setFechasol(String fechasol) {
        this.fechasol = fechasol;
    }

    public String getFechataza() {
        return fechataza;
    }

    public void setFechataza(String fechataza) {
        this.fechataza = fechataza;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public String getResultado_final() {
        return resultado_final;
    }

    public void setResultado_final(String resultado_final) {
        this.resultado_final = resultado_final;
    }

    public String getTiempo_c() {
        return tiempo_c;
    }

    public void setTiempo_c(String tiempo_c) {
        this.tiempo_c = tiempo_c;
    }

    public String getTiempo_f() {
        return tiempo_f;
    }

    public void setTiempo_f(String tiempo_f) {
        this.tiempo_f = tiempo_f;
    }

    public String getSp_aroma() {
        return sp_aroma;
    }

    public void setSp_aroma(String sp_aroma) {
        this.sp_aroma = sp_aroma;
    }

    public String getSp_sabor() {
        return sp_sabor;
    }

    public void setSp_sabor(String sp_sabor) {
        this.sp_sabor = sp_sabor;
    }


}
