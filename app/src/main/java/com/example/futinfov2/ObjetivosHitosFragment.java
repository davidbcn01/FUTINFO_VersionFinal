package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.futinfov2.databinding.FragmentObjetivosHitosBinding;
import com.example.futinfov2.databinding.ViewholderObjetivosNumBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class ObjetivosHitosFragment extends Fragment {
    private NavController navController;
    private FirebaseFirestore db;
    private FragmentObjetivosHitosBinding binding;
    private FirebaseAuth mAuth;
    private List<Objetivo> objetivos = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentObjetivosHitosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);
        mAuth = FirebaseAuth.getInstance();
        TacticasViewModel tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);
        ObjetivosAdapter objetivosAdapter = new ObjetivosAdapter();
        binding.recyclerView.setAdapter(objetivosAdapter);


        tacticasViewModel.getIdSBC().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String idSBC) {
                switch (idSBC) {
                    case "Hitos":
                        binding.encabezado.setText(idSBC.toUpperCase());
                        db.collection("objetivos").document("l2hk6bCEPEhoLwIfBqxf").collection("hitos").addSnapshotListener((value, error) -> {
                            objetivos.clear();
                            value.forEach(document -> {
                                objetivos.add(new Objetivo(document));
                            });
                            objetivosAdapter.notifyDataSetChanged();
                        });

                        binding.button16.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                //te has quedado por aqui bobo
                            db.collection("users").document(mAuth.getUid()).collection("ObjetivosHitos");
                            }
                        });

                        break;
                    case "Jugador de liga":
                        binding.encabezado.setText(idSBC.toUpperCase());
                        db.collection("objetivos").document("kz5BAjAL9T9zU0gHgCiF").collection("liga").addSnapshotListener((value, error) -> {
                            objetivos.clear();
                            value.forEach(document -> {
                                objetivos.add(new Objetivo(document));
                            });
                            objetivosAdapter.notifyDataSetChanged();
                        });


                        break;
                    case "Objetivos diarios":
                        binding.encabezado.setText(idSBC.toUpperCase());
                        db.collection("objetivos").document("PYOIkdC5n5m1QYob4EgD").collection("objetivosDiarios").addSnapshotListener((value, error) -> {
                            objetivos.clear();
                            value.forEach(document -> {
                                objetivos.add(new Objetivo(document));
                            });
                            objetivosAdapter.notifyDataSetChanged();
                        });

                        break;
                }
            }
        });
    }

    static class ObjViewHolder extends RecyclerView.ViewHolder {
        ViewholderObjetivosNumBinding binding;

        public ObjViewHolder(ViewholderObjetivosNumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class ObjetivosAdapter extends RecyclerView.Adapter<ObjViewHolder> {

        @NonNull
        @Override
        public ObjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ObjViewHolder(ViewholderObjetivosNumBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ObjViewHolder holder, int position) {
            Objetivo objetivo = objetivos.get(position);

            holder.binding.titulo.setText(objetivo.getTitulo());
            holder.binding.descrip.setText(objetivo.getDescripcion());
            holder.binding.reward.setText(objetivo.getRecompensa());
            holder.binding.objetivoNum.setText(objetivo.getObjetivo());

           /* int progreso = Integer.parseInt(String.valueOf(holder.binding.editText.getText()));

           binding.button16.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Objetivo obj = new Objetivo(objetivo.getTitulo(),progreso);
                   db.collection("users").document(mAuth.getUid()).collection("objetivos").document(objetivo.idSBCD).set(obj);

               }
           });

*/


        }

        @Override
        public int getItemCount() {
            return objetivos.size();
        }
    }
}