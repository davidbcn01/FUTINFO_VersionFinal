package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.futinfov2.databinding.FragmentInfoSBCBinding;
import com.example.futinfov2.databinding.FragmentRankingsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class rankingsFragment extends Fragment {

    private FragmentRankingsBinding binding;
    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private NavController navController;
    private TacticasViewModel tacticasViewModel;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRankingsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        navController = Navigation.findNavController(view);
        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);
        binding.textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tacticasViewModel.setIdSBC(binding.sb.getText().toString());
                navController.navigate(R.id.action_rankingsFragment_to_rankings2Fragment);
            }
        });
        binding.textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tacticasViewModel.setIdSBC(binding.dv.getText().toString());
                navController.navigate(R.id.action_rankingsFragment_to_rankings2Fragment);
            }
        });
        binding.textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tacticasViewModel.setIdSBC(binding.fc.getText().toString());
                navController.navigate(R.id.action_rankingsFragment_to_rankings2Fragment);
            }
        });
    }
}