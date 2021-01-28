package com.example.futinfov2;

import java.util.ArrayList;
import java.util.List;

public class JugadoresRepositorio2 {
    List<Jugador> jugadoresNormales = new ArrayList<>();
    JugadoresRepositorio2(){
        jugadoresNormales.add(new Jugador("Ronaldo","DC",92,"file:///android_asset/portugal2.png","file:///android_asset/juve.png","file:///android_asset/histiano.png","file:///android_asset/oropeq.png"));
        jugadoresNormales.add(new Jugador("Messi","ED",93,"file:///android_asset/argentina.png","file:///android_asset/barcelona.png","file:///android_asset/messi.png","file:///android_asset/oropeq.png"));
        jugadoresNormales.add(new Jugador("Neymar","EI",91,"file:///android_asset/brasil2.png","file:///android_asset/psg.png","file:///android_asset/neymar.png","file:///android_asset/oropeq.png"));
        jugadoresNormales.add(new Jugador("Mbappé","DC",90,"file:///android_asset/francia.png","file:///android_asset/psg.png","file:///android_asset/mbappe2.png","file:///android_asset/oropeq.png"));
        jugadoresNormales.add(new Jugador("Salah","ED",90,"file:///android_asset/egipto.png","file:///android_asset/liverpool.png","file:///android_asset/salah.png","file:///android_asset/oropeq.png"));
    }
    List<Jugador> obtener(){
        return jugadoresNormales;
    }
}

