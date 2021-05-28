package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentInfoJugadorBinding;
import com.example.futinfov2.databinding.FragmentInicioBinding;


public class InfoJugadorFragment extends Fragment {
FragmentInfoJugadorBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentInfoJugadorBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TacticasViewModel tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);

        tacticasViewModel.getJugadorMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Jugador>() {
            @Override
            public void onChanged(Jugador jugador) {
                binding.posicionCrear.setText(jugador.posicion);
                binding.defenseCrear.setText(jugador.defensa);
                binding.mediaCrear.setText(jugador.media);
                binding.paceCrear.setText(jugador.ritmo);
                binding.shootCrear.setText(jugador.tiro);
                binding.passCrear.setText(jugador.pase);
                binding.dribblingCrear.setText(jugador.regate);
                binding.physicalCrear.setText(jugador.fisico);
                binding.nameCrear.setText(jugador.nombre);
                binding.precio.setText(jugador.precio);

                Glide.with(requireContext()).load(jugador.cara).into(binding.faceCrear);
                Glide.with(requireContext()).load(jugador.cartaG).into(binding.cartaJ);
                Glide.with(requireContext()).load(jugador.pais).into(binding.nacionalidad);
                Glide.with(requireContext()).load(jugador.equipo).into(binding.teamCrear);
            }

        });
    }
}