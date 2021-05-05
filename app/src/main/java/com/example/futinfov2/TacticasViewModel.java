package com.example.futinfov2;

import android.content.ClipData;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TacticasViewModel extends ViewModel {
     private MutableLiveData<String> botonMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getBoton() {
        return botonMutableLiveData;
    }

    public void setBoton(String boton){
        botonMutableLiveData.setValue(boton);
    }
}
