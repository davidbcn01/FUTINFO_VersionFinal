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
}
