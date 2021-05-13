package com.example.futinfov2;

import com.google.firebase.firestore.QueryDocumentSnapshot;

public class Objetivo {
    private String titulo;
    private String descripcion;
    private String recompensa;
    private String objetivo;
    public String idSBCD;
    public int progreso;

    public Objetivo(String titulo,int progreso) {
        this.titulo = titulo;
        this.progreso = progreso;
    }

    public Objetivo(String titulo, String descripcion, String recompensa, String objetivo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.recompensa = recompensa;
        this.objetivo = objetivo;
    }

    public Objetivo(QueryDocumentSnapshot document) {
        this.idSBCD = document.getId();
        this.titulo = document.getString("titulo");
        this.descripcion = document.getString("descripcion");
        this.recompensa = document.getString("recompensa");
        this.objetivo = document.getString("objetivo");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}
