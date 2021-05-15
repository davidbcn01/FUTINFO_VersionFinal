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

        tacticasViewModel.getJugadorMutableLiveData().observe(getViewLifecycleOwner(), new Observer<FirebaseJugadores.Jugador>() {
            @Override
            public void onChanged(FirebaseJugadores.Jugador jugador) {
                binding.posicionCrear.setText(jugador.fields.position.stringValue);
                binding.defenseCrear.setText(jugador.fields.defense.stringValue);
                binding.mediaCrear.setText(jugador.fields.rating.stringValue);
                binding.paceCrear.setText(jugador.fields.pace.stringValue);
                binding.shootCrear.setText(jugador.fields.shoot.stringValue);
                binding.passCrear.setText(jugador.fields.pass.stringValue);
                binding.dribblingCrear.setText(jugador.fields.dribbling.stringValue);
                binding.physicalCrear.setText(jugador.fields.physic.stringValue);
                binding.nameCrear.setText(jugador.fields.name.stringValue);

                Glide.with(requireContext()).load(jugador.fields.face.stringValue).into(binding.faceCrear);
                Glide.with(requireContext()).load(jugador.fields.cardBig.stringValue).into(binding.cartaJ);
                Glide.with(requireContext()).load(jugador.fields.country.stringValue).into(binding.nacionalidad);
                Glide.with(requireContext()).load(jugador.fields.team.stringValue).into(binding.teamCrear);


            }
        });
    }
}