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
import com.example.futinfov2.databinding.FragmentSBCBinding;
import com.example.futinfov2.databinding.ViewholderSbcBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class SBCFragment extends Fragment {
    private FragmentSBCBinding binding;
    private NavController navController;
    private FirebaseFirestore firebaseFirestore;
    private TacticasViewModel tacticasViewModel;

    private List<SBC> SBCs = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentSBCBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseFirestore = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);
        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);
        SbcAdapter sbcAdapter = new SbcAdapter();
        binding.recyclerView.setAdapter(sbcAdapter);
        /*Glide.with(requireContext())
                .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/iconos_app%2FproLeague.png?alt=media&token=3e6177f8-1c92-4360-9986-795c77676d4e")
                .into(binding.img);
                */
        firebaseFirestore.collection("SBC").addSnapshotListener((value, error) -> {
            SBCs.clear();
            value.forEach(document -> {
                String idSBC = document.getId();
                SBCs.add(new SBC(idSBC, document.getString("nombre"), document.getString("imgUrl")));
            });
            sbcAdapter.notifyDataSetChanged();
        });


    }

    class SbcViewHolder extends RecyclerView.ViewHolder {
        ViewholderSbcBinding binding;

        public SbcViewHolder(ViewholderSbcBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class SbcAdapter extends RecyclerView.Adapter<SbcViewHolder> {

        @NonNull
        @Override
        public SbcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SbcViewHolder(ViewholderSbcBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull SbcViewHolder holder, int position) {
            SBC sbc = SBCs.get(position);
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
            return SBCs.size();
        }
    }

}