package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentInfoSBCBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class InfoSBCFragment extends Fragment {
    private FragmentInfoSBCBinding binding;
    private FirebaseFirestore db;
    private FirebaseAuth auth;
    boolean hecho = false;
    private String imagen,imagenSobre;
    SBC sbc2;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentInfoSBCBinding.inflate(inflater, container, false)).getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        TacticasViewModel tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);


        tacticasViewModel.getIdSBC().observe(getViewLifecycleOwner(), idSBC -> {
            //if(binding.checkBox8.isChecked()) hecho = true;
           // System.out.println(s); llega bien el nombre
           // db.collection("users").document(auth.getUid()).collection("sbcDone").add(hecho);
            //String nombre, String imagen, String descripción, String requisitos, String recompensa, String fotoRecompensa

            db.collection("SBC").document(idSBC).addSnapshotListener((value, error) -> {
                SBC sbc = new SBC(value.getString("nombre"),value.getString("imgUrl"),value.getString("descripcion"),value.getString("requisitos"),value.getString("recompensa"),value.getString("imgRecom"));
                       binding.SBCname.setText(sbc.getNombre());
                        binding.descripcion.setText(sbc.getDescripción());
                        binding.textoRequisitos.setText(sbc.getRequisitos());
                        binding.textoRecompensas.setText(sbc.getRecompensa());

                        imagenSobre =sbc.getFotoRecompensa();

                        Glide.with(requireContext())
                                .load(imagenSobre)
                                .into(binding.sobre);


                        imagen = sbc.getImagen();

                        Glide.with(requireContext())
                                .load(imagen)
                                .into(binding.fotoSBC);

                    });

            binding.checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked) {
                        hecho = true;
                        sbc2 = new SBC(hecho);
                        // coll usurios, document (idusurio).colle (sbc).docum(idsbc)
                        db.collection("users").document(auth.getUid()).collection("SBC").document(idSBC).set(sbc2);
                    }else{
                        hecho = false;
                        sbc2 = new SBC(hecho);
                        db.collection("users").document(auth.getUid()).collection("SBC").document(idSBC).set(sbc2);
                    }
                }
            });




            db.collection("users").document(auth.getUid()).collection("SBC").document(idSBC).addSnapshotListener(((value, error) -> {
               boolean realizado= value.getBoolean("hecho");

                   binding.checkBox8.setChecked(realizado);

            }));

        });
    }
}