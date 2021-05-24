package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentRankings2Binding;
import com.example.futinfov2.databinding.ViewholderSbcBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class Rankings2Fragment extends Fragment {

    private FragmentRankings2Binding binding;
    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private NavController navController;
    private TacticasViewModel tacticasViewModel;
    private List<Ranking> Rankings = new ArrayList<>();
    String coleccion;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRankings2Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        auth=FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);
        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);
        RankingsAdapter Adapter = new RankingsAdapter();
        binding.recyclerView.setAdapter(Adapter);
        tacticasViewModel.getIdSBC().observe(getViewLifecycleOwner(),idSBC ->{
            switch(idSBC){

                case "Squad Battles":

                    coleccion = idSBC;

                    break;
                case "Jugador de liga":
                    coleccion = idSBC;

                    break;
                case "Objetivos diarios":
                    coleccion = idSBC;
                    break;
            }
            db.collection(coleccion).addSnapshotListener((value, error) -> {
                Rankings.clear();
                value.forEach(document ->{
                    Rankings.add(new Ranking(document.getString("rango"),
                            document.getString("imgRank"),
                            document.getId()));

                });
                Adapter.notifyDataSetChanged();
            });

        });
    }

    class RankingsViewHolder extends RecyclerView.ViewHolder {
        ViewholderSbcBinding binding;

        public RankingsViewHolder(ViewholderSbcBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class RankingsAdapter extends RecyclerView.Adapter<RankingsViewHolder> {

        @NonNull
        @Override
        public RankingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RankingsViewHolder(ViewholderSbcBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RankingsViewHolder holder, int position) {
            Ranking ranking = Rankings.get(position);
            holder.binding.nombreSBC.setText(ranking.nombreRank);
            Glide.with(requireView()).load(ranking.imgRank).into(holder.binding.img);

            holder.binding.const4.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    tacticasViewModel.setIdSBC(ranking.idSBCD);
                    tacticasViewModel.setNombreMutableLiveData(coleccion);
                    navController.navigate(R.id.action_rankings2Fragment_to_rankings3Fragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return Rankings.size();
        }
    }
}