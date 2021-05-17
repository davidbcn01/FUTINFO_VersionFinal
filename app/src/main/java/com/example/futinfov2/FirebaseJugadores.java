package com.example.futinfov2;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class FirebaseJugadores {

    class Jugadores {
        List<Jugador> documents;
    }

    class Jugador {
        String name;
        Fields fields;
    }

    class Fields {
       Value country;
       Value face;
       Value name;
       Value position;
       Value rating;
       Value team;
       Value card;
       Value pace;
       Value shoot;
       Value pass;
       Value dribbling;
       Value defense;
       Value physic;
       Value cardBig;
       Value price;
    }

    class Value {
        String stringValue;
    }


    public static Api api = new Retrofit.Builder()
            .baseUrl("https://firestore.googleapis.com/v1/projects/futinfo-1b129/databases/(default)/documents/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api.class);

    public interface Api {
        @GET("jugadores")
        Call<Jugadores> obtener();
    }
}