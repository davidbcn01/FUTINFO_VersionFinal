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

import com.example.futinfov2.databinding.FragmentFutchamps1Binding;
import com.example.futinfov2.databinding.FragmentVerFutChampsBinding;
import com.example.futinfov2.databinding.ViewholderBotonFutchampsBinding;
import com.example.futinfov2.databinding.ViewholderPartidosBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class VerFutChampsFragment extends Fragment {
    private FragmentVerFutChampsBinding binding;
    private NavController navController;
    private List<Partido> partidosFut = new ArrayList<>();
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private TacticasViewModel tacticasViewModel;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentVerFutChampsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        db = FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();
        ChampsAdapter adapter = new ChampsAdapter();
        binding.recyclerView.setAdapter(adapter);
        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);


        tacticasViewModel.getIdSBC().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                db.collection("users").document(mAuth.getUid()).collection("futChamps").document(s).collection("partidos").addSnapshotListener((value, error) -> {
                    partidosFut.clear();
                    value.forEach(document ->{
                        partidosFut.add(new Partido(
                                document.getString("numPartido"),
                                document.getString("resultado"),
                                document.getString("goles"),
                                document.getString("asistencias"),
                                document.getString("posesion"),
                                document.getString("tiros"),
                                document.getString("paradas")));
                    });
                    adapter.notifyDataSetChanged();
                });
            }
        });
    }
    class ChampsViewHolder extends RecyclerView.ViewHolder {
        ViewholderPartidosBinding binding;

        public ChampsViewHolder(ViewholderPartidosBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
    class ChampsAdapter extends RecyclerView.Adapter<ChampsViewHolder>{

        @NonNull
        @Override
        public ChampsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ChampsViewHolder(ViewholderPartidosBinding.inflate(getLayoutInflater(),parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ChampsViewHolder holder, int position) {
            Partido partido = partidosFut.get(position);

            holder.binding.partido.setText(partido.numPartido);
            holder.binding.resultadoP.setText(partido.resultado);
            holder.binding.golesP.setText(partido.goles);
            holder.binding.asistenciasP.setText(partido.asistencias);
            holder.binding.tirosP.setText(partido.tiros);
            holder.binding.posesionP.setText(partido.posesion);
            holder.binding.paradasP.setText(partido.paradas);



        }

        @Override
        public int getItemCount() {
            return partidosFut.size();
        }
    }
}