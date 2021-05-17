package com.example.futinfov2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TacticasViewModel extends ViewModel {
     private MutableLiveData<String> idSBCMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> nombreMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> partidoMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<FirebaseJugadores.Jugador> jugadorMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getIdSBC() {
        return idSBCMutableLiveData;
    }

    public void setIdSBC(String boton){
        idSBCMutableLiveData.setValue(boton);
    }
    public MutableLiveData<String> getNombreMutableLiveData() {
        return nombreMutableLiveData;
    }

    public void setNombreMutableLiveData(String nombre){
        nombreMutableLiveData.setValue(nombre);
    }
    public MutableLiveData<String> getPartidoMutableLiveData() {
        return partidoMutableLiveData;
    }

    public void setPartidoMutableLiveData(String partido){
        partidoMutableLiveData.setValue(partido);
    }

    public MutableLiveData<FirebaseJugadores.Jugador> getJugadorMutableLiveData() {
        return jugadorMutableLiveData;
    }

    public void setJugadorMutableLiveData(FirebaseJugadores.Jugador jugador) {
        jugadorMutableLiveData.setValue(jugador);
    }
}
