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
import com.example.futinfov2.databinding.FragmentRankings2Binding;
import com.example.futinfov2.databinding.FragmentRankings3Binding;
import com.example.futinfov2.databinding.FragmentRankingsBinding;
import com.example.futinfov2.databinding.ViewholderPartidosBinding;
import com.example.futinfov2.databinding.ViewholderRankingsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class Rankings3Fragment extends Fragment {
    private FragmentRankings3Binding binding;
    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private NavController navController;
    private TacticasViewModel tacticasViewModel;
    private List<Ranking> Rankings = new ArrayList<>();
    String coleccion;




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRankings3Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        auth=FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);
        ShowRankAdapter Adapter = new ShowRankAdapter();
        binding.recyclerView.setAdapter(Adapter);
        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);
        tacticasViewModel.getNombreMutableLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                coleccion = s;
            }
        });
        tacticasViewModel.getIdSBC().observe(getViewLifecycleOwner(), new Observer<String>(){

            @Override
            public void onChanged(String s) {
                db.collection(coleccion).document(s).collection("rangos").addSnapshotListener((value, error) -> {
                    Rankings.clear();
                    value.forEach(document ->{
                        Rankings.add(new Ranking(document.getString("rango"),
                                document.getString("imgRango"),
                                document.getString("recompensa1"),
                                document.getString("recompensa2"),
                                document.getString("recompensa3"),
                                document.getString("objetivo")));

                    });
                    Adapter.notifyDataSetChanged();
                });

            }
        });
    }
    class ShowRankViewHolder extends RecyclerView.ViewHolder {
        ViewholderRankingsBinding binding;

        public ShowRankViewHolder(ViewholderRankingsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
    class ShowRankAdapter extends RecyclerView.Adapter<ShowRankViewHolder>{

        @NonNull
        @Override
        public ShowRankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ShowRankViewHolder(ViewholderRankingsBinding.inflate(getLayoutInflater(),parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ShowRankViewHolder holder, int position) {
            Ranking ranking = Rankings.get(position);
            holder.binding.rec1.setText(ranking.recompensa1);
            holder.binding.rec2.setText(ranking.recompensa3);
            holder.binding.rec3.setText(ranking.recompensa2);
            holder.binding.rank.setText(ranking.nombreRank);
            holder.binding.objetivoR.setText(ranking.objetivo);
            Glide.with(requireView()).load(ranking.imgRank).into(holder.binding.imageView2);




        }

        @Override
        public int getItemCount() {
            return Rankings.size();
        }
    }
}