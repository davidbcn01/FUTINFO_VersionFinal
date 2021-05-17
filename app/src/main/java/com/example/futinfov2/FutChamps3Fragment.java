package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

;
import com.example.futinfov2.databinding.FragmentFutChamps3Binding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.List;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;


public class FutChamps3Fragment extends Fragment {
    private FragmentFutChamps3Binding binding;
    private NavController navController;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    String partido;
    String nombreFutC;
    String id;
    String goles;
    String asistencias;
    String posesion;
    String resultado;
    String paradas;
    String tiros;
    private List<FutChamps> futChampsexistentes = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentFutChamps3Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);
        mAuth = FirebaseAuth.getInstance();
        TacticasViewModel tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);

        tacticasViewModel.getPartidoMutableLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                partido = s;
                binding.partido.setText(partido);
            }
        });
        tacticasViewModel.getNombreMutableLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                nombreFutC = s;
            }
        });

        PushDownAnim.setPushDownAnimTo(binding.save)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         goles = binding.jugadorgoles.getText().toString();
                         asistencias = binding.jugadorAsist.getText().toString();
                         posesion = binding.jugadorposesion.getText().toString();
                         resultado = binding.marcador.getText().toString();
                         paradas = binding.jugadorParadas.getText().toString();
                         tiros = binding.jugadorTiros.getText().toString();

                        //por aqui
                        db.collection("users").document(mAuth.getUid()).collection("futChamps").addSnapshotListener((value, error) -> {
                            futChampsexistentes.clear();
                            value.forEach(document ->{
                                futChampsexistentes.add(new FutChamps(
                                        document.getId(),
                                        document.getString("nombre")));
                            });
                            for (int i = 0; i<futChampsexistentes.size();i++){
                                System.out.println(nombreFutC);
                                System.out.println(futChampsexistentes.get(i).id);
                                System.out.println("hola asdfg");
                                if (futChampsexistentes.get(i).getNombre().equals(nombreFutC)){
                                    System.out.println(futChampsexistentes.get(i).id);
                                    Partido newPartido = new Partido(partido,resultado,goles,asistencias,posesion,tiros,paradas);
                                    db.collection("users").document(mAuth.getUid()).collection("futChamps").document(futChampsexistentes.get(i).id).collection("partidos").add(newPartido);
                                }
                            }
                        });


                        navController.navigate(R.id.action_futChamps3Fragment_to_futChamp2Fragment);
                    }
                });
    }
}