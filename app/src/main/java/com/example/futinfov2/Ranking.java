package com.example.futinfov2;

public class Ranking {
    public String nombreRank;
    public String imgRank;
    public String idSBCD;
    String recompensa1;
    String recompensa2;
    String recompensa3;
    String objetivo;

    public Ranking(String nombreRank, String imgRank, String recompensa1, String recompensa2, String recompensa3, String objetivo) {
        this.nombreRank = nombreRank;
        this.imgRank = imgRank;
        this.recompensa1 = recompensa1;
        this.recompensa2 = recompensa2;
        this.recompensa3 = recompensa3;
        this.objetivo = objetivo;
    }

    public Ranking(String nombreRank, String imgRank, String idSBCD) {
        this.nombreRank = nombreRank;
        this.imgRank = imgRank;
        this.idSBCD = idSBCD;
    }

    public Ranking(String nombre, String imgRank) {
        this.nombreRank = nombre;
        this.imgRank = imgRank;
    }

    public String getNombreRank() {
        return nombreRank;
    }

    public String getImgRank() {
        return imgRank;
    }
}
