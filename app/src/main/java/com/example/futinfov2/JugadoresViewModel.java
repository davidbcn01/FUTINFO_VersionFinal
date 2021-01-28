package com.example.futinfov2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class JugadoresViewModel extends AndroidViewModel {

    JugadoresRepositorio jugadoresRepositorio;
    MutableLiveData<List<Jugador>> listJugadoresMutableLiveData = new MutableLiveData<>();

public JugadoresViewModel(@NonNull Application application){
    super(application);
    jugadoresRepositorio = new JugadoresRepositorio();
    listJugadoresMutableLiveData.setValue(jugadoresRepositorio.obtener());
}

MutableLiveData<List<Jugador>> obtener(){
    return listJugadoresMutableLiveData;
}


}
