package com.example.proyecto_cafe;

import android.widget.EditText;

public class Modelo_MateriaPrima {

    private String m_id_mp;
    private String m_fecha_mp;
    private String m_lotes_acept;
    private String m_lotes_rechazado;
    private String m_sacos_cafe_arab;
    private String m_sacos_cafe_rob;
    private String m_grado_rob;
    private String m_grado_arab;

    public Modelo_MateriaPrima() {
    }

    public String getM_id_mp() {
        return m_id_mp;
    }

    public void setM_id_mp(String m_id_mp) {
        this.m_id_mp = m_id_mp;
    }

    public String getM_fecha_mp() {
        return m_fecha_mp;
    }

    public void setM_fecha_mp(String m_fecha_mp) {
        this.m_fecha_mp = m_fecha_mp;
    }

    public String getM_lotes_acept() {
        return m_lotes_acept;
    }

    public void setM_lotes_acept(String m_lotes_acept) {
        this.m_lotes_acept = m_lotes_acept;
    }

    public String getM_lotes_rechazado() {
        return m_lotes_rechazado;
    }

    public void setM_lotes_rechazado(String m_lotes_rechazado) {
        this.m_lotes_rechazado = m_lotes_rechazado;
    }

    public String getM_sacos_cafe_arab() {
        return m_sacos_cafe_arab;
    }

    public void setM_sacos_cafe_arab(String m_sacos_cafe_arab) {
        this.m_sacos_cafe_arab = m_sacos_cafe_arab;
    }

    public String getM_sacos_cafe_rob() {
        return m_sacos_cafe_rob;
    }

    public void setM_sacos_cafe_rob(String m_sacos_cafe_rob) {
        this.m_sacos_cafe_rob = m_sacos_cafe_rob;
    }

    public String getM_grado_rob() {
        return m_grado_rob;
    }

    public void setM_grado_rob(String m_grado_rob) {
        this.m_grado_rob = m_grado_rob;
    }

    public String getM_grado_arab() {
        return m_grado_arab;
    }

    public void setM_grado_arab(String m_grado_arab) {
        this.m_grado_arab = m_grado_arab;
    }

    @Override
    public String toString() {
        return m_fecha_mp;
    }
}