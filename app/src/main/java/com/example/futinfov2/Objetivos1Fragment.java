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

import com.example.futinfov2.databinding.FragmentObjetivos1Binding;
import com.google.firebase.firestore.FirebaseFirestore;


public class Objetivos1Fragment extends Fragment {
    FragmentObjetivos1Binding binding;
    private NavController navController;
    private TacticasViewModel tacticasViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentObjetivos1Binding.inflate(inflater, container, false)).getRoot();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);


        binding.textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.textView7.getText());
                navController.navigate(R.id.action_objetivos1Fragment_to_objetivosHitosFragment);
            }
        });
        binding.textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.textView8.getText());
                navController.navigate(R.id.action_objetivos1Fragment_to_objetivosHitosFragment);
            }
        });
        binding.textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.textView9.getText());
                navController.navigate(R.id.action_objetivos1Fragment_to_objetivosHitosFragment);
            }
        });

    }

}