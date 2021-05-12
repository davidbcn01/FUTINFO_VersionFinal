package com.example.futinfov2;

public class SBC {
    public String idSBCD;
    public String nombre;
    public String imagen;
    public String descripción;
    public String requisitos;
    public String recompensa;
    public String fotoRecompensa;
    public boolean hecho;

    public SBC(boolean hecho) {
        this.hecho = hecho;
    }

    public SBC(String idSBC, String nombre, String imagen) {
        this.idSBCD = idSBC;
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

    public SBC(String nombre, String imagen, String descripción, String requisitos, String recompensa, String fotoRecompensa) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripción = descripción;
        this.requisitos = requisitos;
        this.recompensa = recompensa;
        this.fotoRecompensa = fotoRecompensa;
    }
}
