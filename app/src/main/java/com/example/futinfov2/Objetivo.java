package com.example.futinfov2;

import com.google.firebase.firestore.QueryDocumentSnapshot;

public class Objetivo {
    private String titulo;
    private String descripcion;
    private String recompensa;
    private String objetivo;
    public String idSBCD;
    public String progreso;

    public Objetivo(String titulo,String progreso) {
        this.titulo = titulo;
        this.progreso = progreso;
    }

    public Objetivo(String titulo, String descripcion, String recompensa, String objetivo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.recompensa = recompensa;
        this.objetivo = objetivo;
    }

    public Objetivo() {
    }

    public Objetivo(String titulo, String descripcion, String recompensa, String objetivo, String progreso) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.recompensa = recompensa;
        this.objetivo = objetivo;
        this.progreso = progreso;
    }

    public Objetivo(String progreso) {
        this.progreso = progreso;
    }

    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }

    public Objetivo(QueryDocumentSnapshot document) {
        this.idSBCD = document.getId();
        this.titulo = document.getString("titulo");
        this.descripcion = document.getString("descripcion");
        this.recompensa = document.getString("recompensa");
        this.objetivo = document.getString("objetivo");
        this.progreso = document.getString("progreso");
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
