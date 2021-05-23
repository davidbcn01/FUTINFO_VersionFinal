package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
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
    private List<SBC> Rankings = new ArrayList<>();



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRankings2Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
            SBC sbc = Rankings.get(position);
            holder.binding.nombreSBC.setText(sbc.nombre);
            Glide.with(requireView()).load(sbc.imagen).into(holder.binding.img);

            holder.binding.const4.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    tacticasViewModel.setIdSBC(sbc.idSBCD);
                    navController.navigate(R.id.action_SBCFragment_to_infoSBCFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return Rankings.size();
        }
    }
}