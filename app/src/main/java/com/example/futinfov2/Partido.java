package com.example.futinfov2;

public class Partido {
    public String numPartido;
    public String resultado;
    public String goles;
    public String asistencias;
    public String posesion;
    public String tiros;
    public String paradas;

    public Partido(String numPartido, String resultado, String goles, String asistencias, String posesion, String tiros, String paradas) {
        this.numPartido = numPartido;
        this.resultado = resultado;
        this.goles = goles;
        this.asistencias = asistencias;
        this.posesion = posesion;
        this.tiros = tiros;
        this.paradas = paradas;
    }
}
