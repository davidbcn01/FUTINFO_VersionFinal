package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentChangePasswordBinding;
import com.example.futinfov2.databinding.FragmentCrearTuCartaBinding;


public class CrearTuCartaFragment extends Fragment {

    private FragmentCrearTuCartaBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCrearTuCartaBinding.inflate(inflater, container, false)).getRoot();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);


        binding.constraintLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(requireContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/cartas%2FtotwGrande.png?alt=media&token=d251ed9c-e017-4a69-8e5e-3a935b13f211")
                        .into(binding.carta);


            }
        });

        binding.constraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(requireContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/cartas%2FiconoGrande.png?alt=media&token=443a61ba-64c7-4574-b543-3f306ee2d5f0")
                        .into(binding.carta);

            }
        });
        binding.constraintLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(requireContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/cartas%2ForoGrande.png?alt=media&token=4461e0df-7895-401d-8bfd-31dc5745cb4f")
                        .into(binding.carta);


            }
        });

    }
}