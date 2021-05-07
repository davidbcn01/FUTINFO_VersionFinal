package com.example.futinfov2;

public class SBC {
    public String nombre;
    public String imagen;
    boolean hecho;
    public String descripción;
    public String requisitos;
    public String recompensa;
    public String fotoRecompensa;

    public SBC(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isHecho() {
        return hecho;
    }

    public void setHecho(boolean hecho) {
        this.hecho = hecho;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    public String getFotoRecompensa() {
        return fotoRecompensa;
    }

    public void setFotoRecompensa(String fotoRecompensa) {
        this.fotoRecompensa = fotoRecompensa;
    }

    public SBC(String nombre, String imagen, boolean hecho, String descripción, String requisitos, String recompensa, String fotoRecompensa) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.hecho = hecho;
        this.descripción = descripción;
        this.requisitos = requisitos;
        this.recompensa = recompensa;
        this.fotoRecompensa = fotoRecompensa;
    }
}
