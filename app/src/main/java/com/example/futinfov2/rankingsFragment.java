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

import com.bumptech.glide.Glide;
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
        Glide.with(requireContext())
                .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/iconos_app%2FFUT-CHampions.png?alt=media&token=1ebb8114-64e7-46c3-993a-6cbb99508ee4")
                .into(binding.imageView5);
        Glide.with(requireContext())
                .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/iconos_app%2Frivals.png?alt=media&token=8747ba46-0b49-40e5-b810-661707a59e60")
                .into(binding.image);
        Glide.with(requireContext())
                .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/iconos_app%2Fsquad-battles.png?alt=media&token=2e170b40-b423-40d2-9f04-9442f6b25a94")
                .into(binding.imageView4);

        }
}