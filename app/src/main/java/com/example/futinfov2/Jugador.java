package com.example.futinfov2;

public class Jugador {
    String nombre;
    String posicion;
    String media;
    String pais;
    String equipo;
    String cara;
    String tipo;
    String ritmo;
    String tiro;
    String pase;
    String regate;
    String defensa;
    String fisico;
    String cartaG;
    String cartaP;
    String precio;

    public Jugador(String nombre, String posicion, String media, String pais, String equipo, String cara, String ritmo, String tiro, String pase, String regate, String defensa, String fisico, String cartaG, String cartaP, String precio) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.media = media;
        this.pais = pais;
        this.equipo = equipo;
        this.cara = cara;
        this.ritmo = ritmo;
        this.tiro = tiro;
        this.pase = pase;
        this.regate = regate;
        this.defensa = defensa;
        this.fisico = fisico;
        this.cartaG = cartaG;
        this.cartaP = cartaP;
        this.precio = precio;
    }

    public Jugador(String nombre, String posicion, String media, String pais, String equipo, String cara, String tipo) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.media = media;
        this.pais = pais;
        this.equipo = equipo;
        this.cara = cara;
        this.tipo = tipo;
    }
}
