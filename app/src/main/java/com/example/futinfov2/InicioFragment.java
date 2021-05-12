package com.example.futinfov2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentInicioBinding;
import com.google.firebase.firestore.FirebaseFirestore;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class InicioFragment extends Fragment {

    FragmentInicioBinding binding;
    private NavController navController;
    private FirebaseFirestore firebaseFirestore;
    private TacticasViewModel tacticasViewModel;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentInicioBinding.inflate(inflater, container, false)).getRoot();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        firebaseFirestore = FirebaseFirestore.getInstance();
        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);
        firebaseFirestore.collection("jugadores").document("iUZSJOddr0oP8hL2NJJp").addSnapshotListener(((value, error) ->{
            Jugador jugador = new Jugador(value.getString("name"),value.getString("position"), Math.toIntExact(value.getLong("rating")),value.getString("country"),value.getString("team"),value.getString("face"),value.getString("card"));
            binding.position2.setText(jugador.posicion);
            binding.name.setText(jugador.nombre);
            binding.rating.setText(String.valueOf(jugador.media));
            Glide.with(requireContext())
                    .load(jugador.cara)
                    .into(binding.face);
            Glide.with(requireContext())
                    .load(jugador.pais)
                    .into(binding.country);
            Glide.with(requireContext())
                    .load(jugador.equipo)
                    .into(binding.team);
            Glide.with(requireContext())
                    .load(jugador.tipo)
                    .into(binding.tipo);

        }

                ));



        Glide.with(requireContext())
                .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/iconos_app%2FxpIcon.png?alt=media&token=cc6a994b-65e8-45dd-bfb3-7fea549374d3")
                .into(binding.imageView3);



        binding.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setIdSBC("Hitos");
                navController.navigate(R.id.action_inicioFragment_to_objetivosHitosFragment);
            }
        });
        binding.imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setIdSBC("Objetivos diarios");
                navController.navigate(R.id.action_inicioFragment_to_objetivosHitosFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setIdSBC((String) binding.button.getText());
                navController.navigate(R.id.action_inicioFragment_to_tacticasOfensivasFragment);
            }
        });

        PushDownAnim.setPushDownAnimTo( binding.button2)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setIdSBC((String) binding.button2.getText());
                navController.navigate(R.id.action_inicioFragment_to_tacticasOfensivasFragment);
            }
        });
    }
}