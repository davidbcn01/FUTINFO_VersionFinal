package com.example.futinfov2;

import android.text.Editable;

public class Tactica {
    public String ataque,defensa,laterales,centrocampistas,delanteros,formacion;
    public String nombre;

    public Tactica(String ataque, String defensa, String laterales, String centrocampistas, String delanteros, String formacion) {
        this.ataque = ataque;
        this.defensa = defensa;
        this.laterales = laterales;
        this.centrocampistas = centrocampistas;
        this.delanteros = delanteros;
        this.formacion = formacion;
    }

    public Tactica(String ataque, String defensa, String laterales, String centrocampistas, String delanteros, String formacion, String nombre) {
        this.ataque = ataque;
        this.defensa = defensa;
        this.laterales = laterales;
        this.centrocampistas = centrocampistas;
        this.delanteros = delanteros;
        this.formacion = formacion;
        this.nombre = nombre;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getDefensa() {
        return defensa;
    }

    public void setDefensa(String defensa) {
        this.defensa = defensa;
    }

    public String getLaterales() {
        return laterales;
    }

    public void setLaterales(String laterales) {
        this.laterales = laterales;
    }

    public String getCentrocampistas() {
        return centrocampistas;
    }

    public void setCentrocampistas(String centrocampistas) {
        this.centrocampistas = centrocampistas;
    }

    public String getDelanteros() {
        return delanteros;
    }

    public void setDelanteros(String delanteros) {
        this.delanteros = delanteros;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tactica(String nombre) {
        this.nombre = nombre;
    }
}
