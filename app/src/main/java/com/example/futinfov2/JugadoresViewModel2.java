package com.example.futinfov2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class JugadoresViewModel2 extends AndroidViewModel {
    JugadoresRepositorio2 jugadoresRepositorio2;
    MutableLiveData<List<Jugador>> listJugadores2MutableLiveData = new MutableLiveData<>();

    public JugadoresViewModel2(@NonNull Application application){
        super(application);
        jugadoresRepositorio2 = new JugadoresRepositorio2();
        listJugadores2MutableLiveData.setValue(jugadoresRepositorio2.obtener());
    }

    MutableLiveData<List<Jugador>> obtener(){
        return listJugadores2MutableLiveData;
    }


}

