package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentInfoSBCBinding;
import com.example.futinfov2.databinding.FragmentTacticasOfensivasBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class InfoSBCFragment extends Fragment {
    private FragmentInfoSBCBinding binding;
    private FirebaseFirestore db;
    private FirebaseAuth auth;
    boolean hecho = false;
    private List<SBC> listaSBC = new ArrayList<>();
    private List<SBC> listaSBC2 = new ArrayList<>();
    private String imagen;


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


        tacticasViewModel.getBoton().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                if(binding.checkBox8.isChecked()) hecho = true;

                db.collection("users").document(auth.getUid()).collection("sbcDone").add(hecho);

                db.collection("SBC").addSnapshotListener((value, error) -> {
                    listaSBC.clear();
                    value.forEach(document ->{
                        listaSBC.add(new SBC(document.getString("nombre"),
                                document.getString("imgUrl"),
                                document.getBoolean("hecho"),
                                document.getString("descripcion"),
                                document.getString("requisitos"),
                                document.getString("recompensa"),
                                document.getString("imgRecom")));
                    });
                    for(int i = 0; i<listaSBC.size();i++){
                        if(listaSBC.get(i).getNombre().equals(s)){
                           binding.SBCname.setText(listaSBC.get(i).getNombre());
                            binding.descripcion.setText(listaSBC.get(i).getDescripción());
                            binding.textoRequisitos.setText(listaSBC.get(i).getRequisitos());
                            binding.recompensas.setText(listaSBC.get(i).getRecompensa());

                            Glide.with(requireContext())
                                    .load(listaSBC.get(i).getFotoRecompensa())
                                    .into(binding.sobre);
                            imagen = listaSBC.get(i).getImagen();
                            Glide.with(requireContext())
                                    .load(imagen)
                                    .into(binding.fotoSBC);

                        }
                    }
                    value.forEach(document->{
                        listaSBC2.clear();
                        listaSBC2.add(new SBC(document.getString("nombre"),document.getString("imgUrl")));
                    });
                    for(int i = 0; i<listaSBC2.size();i++){
                        if(listaSBC2.get(i).getNombre().equals(s) && listaSBC2.get(i).getImagen().equals(imagen)){
                          //
                            listaSBC2.get(i).isHecho();

                        }
                    }
                });
            }
        });
    }
}