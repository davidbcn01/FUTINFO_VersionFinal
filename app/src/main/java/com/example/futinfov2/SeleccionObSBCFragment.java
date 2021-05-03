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
import com.example.futinfov2.databinding.FragmentInicioBinding;
import com.example.futinfov2.databinding.FragmentSeleccionObSBCBinding;


public class SeleccionObSBCFragment extends Fragment {

    FragmentSeleccionObSBCBinding binding;
    private NavController navController;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentSeleccionObSBCBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        Glide.with(requireContext())
                .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/iconos_app%2FplayerPick%2B84.png?alt=media&token=2abb0a37-3286-435e-b620-9ac02b4e92e7")
                .into(binding.imgSbc);
        Glide.with(requireContext()).load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/iconos_app%2FxpIcon.png?alt=media&token=cc6a994b-65e8-45dd-bfb3-7fea549374d3")
                .into(binding.imgOb);

        binding.const2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_seleccionObSBCFragment_to_SBCFragment);
            }
        });
        binding.const1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_seleccionObSBCFragment_to_objetivos1Fragment);
            }
        });
    }
}