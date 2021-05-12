package com.example.futinfov2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TacticasViewModel extends ViewModel {
     private MutableLiveData<String> idSBCMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getIdSBC() {
        return idSBCMutableLiveData;
    }

    public void setIdSBC(String boton){
        idSBCMutableLiveData.setValue(boton);
    }
}
