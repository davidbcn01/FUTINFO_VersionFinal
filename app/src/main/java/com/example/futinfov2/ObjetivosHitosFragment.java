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

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentObjetivos1Binding;
import com.example.futinfov2.databinding.FragmentObjetivosHitosBinding;
import com.example.futinfov2.databinding.ViewholderObjetivosNumBinding;
import com.example.futinfov2.databinding.ViewholderSbcBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class ObjetivosHitosFragment extends Fragment {
    private NavController navController;
    private FirebaseFirestore firebaseFirestore;
    private FragmentObjetivosHitosBinding binding;
    private List<Objetivo> objetivos = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentObjetivosHitosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firebaseFirestore = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);
        TacticasViewModel tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);
        ObjetivosAdapter objetivosAdapter = new ObjetivosAdapter();
        binding.recyclerView.setAdapter(objetivosAdapter);


        tacticasViewModel.getBoton().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                if(s.equals("Hitos")){
                    binding.encabezado.setText(s.toUpperCase());
                    firebaseFirestore.collection("objetivos").document("l2hk6bCEPEhoLwIfBqxf").collection("hitos").addSnapshotListener((value, error) -> {
                        objetivos.clear();
                        value.forEach(document ->{
                            objetivos.add(new Objetivo(document.getString("titulo"),
                                    document.getString("descripcion"),
                                    document.getString("recompensa"),
                                    document.getString("objetivo")));
                        });
                        objetivosAdapter.notifyDataSetChanged();
                    });
                }

                if(s.equals("Jugador de liga")){
                  binding.encabezado.setText(s.toUpperCase());
                    firebaseFirestore.collection("objetivos").document("kz5BAjAL9T9zU0gHgCiF").collection("liga").addSnapshotListener((value, error) -> {
                        objetivos.clear();
                        value.forEach(document ->{
                            objetivos.add(new Objetivo(document.getString("titulo"),
                                    document.getString("descripcion"),
                                    document.getString("recompensa"),
                                    document.getString("objetivo")));
                        });
                        objetivosAdapter.notifyDataSetChanged();
                    });


                }

                if (s.equals("Objetivos diarios")){
                    binding.encabezado.setText(s.toUpperCase());

                }
            }
        });


    }
    class ObjViewHolder extends RecyclerView.ViewHolder {
        ViewholderObjetivosNumBinding binding;

        public ObjViewHolder(ViewholderObjetivosNumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    class ObjetivosAdapter extends RecyclerView.Adapter<ObjViewHolder>{

        @NonNull
        @Override
        public ObjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ObjViewHolder(ViewholderObjetivosNumBinding.inflate(getLayoutInflater(),parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ObjViewHolder holder, int position) {
            Objetivo objetivo = objetivos.get(position);
           holder.binding.titulo.setText(objetivo.getTitulo());
           holder.binding.descrip.setText(objetivo.getDescripcion());
           holder.binding.reward.setText(objetivo.getRecompensa());
           holder.binding.objetivoNum.setText(objetivo.getObjetivo());

        }

        @Override
        public int getItemCount() {
            return objetivos.size();
        }
    }
}