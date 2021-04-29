package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentCrearTuCartaBinding;
import com.example.futinfov2.databinding.FragmentSBCBinding;
import com.google.firebase.storage.FirebaseStorage;


public class SBCFragment extends Fragment {
    private FragmentSBCBinding binding;
    private NavController navController;
    private FirebaseStorage firebaseStorage;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentSBCBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*Glide.with(requireContext())
                .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/iconos_app%2FproLeague.png?alt=media&token=3e6177f8-1c92-4360-9986-795c77676d4e")
                .into(binding.img);
                */

    }
}