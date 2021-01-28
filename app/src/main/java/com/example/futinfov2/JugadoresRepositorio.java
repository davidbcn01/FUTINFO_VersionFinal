package com.example.futinfov2;

import java.util.ArrayList;
import java.util.List;

public class JugadoresRepositorio {
    List<Jugador> jugadores = new ArrayList<>();
    JugadoresRepositorio(){
        jugadores.add(new Jugador("Pelé","SD",91,"file:///android_asset/brasil2.png","file:///android_asset/escudo_icono.png","file:///android_asset/carapele.png","file:///android_asset/icono.png"));
        jugadores.add(new Jugador("Ronaldo","DC",94,"file:///android_asset/brasil2.png","file:///android_asset/escudo_icono.png","file:///android_asset/nazario.png","file:///android_asset/icono.png"));
        jugadores.add(new Jugador("Eusebio","SD",89,"file:///android_asset/portugal2.png","file:///android_asset/escudo_icono.png","file:///android_asset/eusebio2.png","file:///android_asset/icono.png"));
        jugadores.add(new Jugador("Gullit","SD",90,"file:///android_asset/holanda.png","file:///android_asset/escudo_icono.png","file:///android_asset/gullit.png","file:///android_asset/icono.png"));
        jugadores.add(new Jugador("Cruyff","SD",91,"file:///android_asset/holanda.png","file:///android_asset/escudo_icono.png","file:///android_asset/cara_cruyff.png","file:///android_asset/icono.png"));
    }
    List<Jugador> obtener(){
        return jugadores;
    }
}
