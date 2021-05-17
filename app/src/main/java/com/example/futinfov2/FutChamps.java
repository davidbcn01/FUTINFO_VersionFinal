package com.example.futinfov2;

public class FutChamps {
    public String nombre;
    public String id;

    public FutChamps(String id, String nombre) {
        this.nombre = nombre;
        this.id = id;
    }

    public FutChamps(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
