package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.futinfov2.databinding.FragmentTacticasEleccionBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class TacticasEleccionFragment extends Fragment {

    private FragmentTacticasEleccionBinding binding;
    private NavController navController;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    String ataque;
    String defensa;
    String laterales;
    String centrocampistas;
    String delanteros;
    String formacion;
    String nombreT;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentTacticasEleccionBinding.inflate(inflater, container, false)).getRoot();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();



        TacticasViewModel tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);
        tacticasViewModel.getIdSBC().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                formacion = s;
            }
        });






        PushDownAnim.setPushDownAnimTo(binding.button)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.checkEquilibrado1.isChecked()) {
                    ataque = "Equilibrado";
                }
                if(binding.checkPosesion.isChecked()) ataque = "Posesión";

                if(binding.checkContraataque.isChecked()) ataque = "Contraataque";

                if(binding.checkEquilibrado2.isChecked()) defensa = "Equilibrado";

                if(binding.checkRepliegue.isChecked()) defensa = "Repliegue";

                if(binding.checkPresionFuerte.isChecked())  defensa = "Presion Fuerte";

                if(binding.checkEquilibrado3.isChecked()) laterales ="Equilibrado";

                if (binding.checkQuedarseAtras.isChecked()) laterales = "Quedarse atras";

                if(binding.checkSubirAlAtaque.isChecked()) laterales ="Subir al ataque";

                if(binding.checkEquilibrado4.isChecked()) centrocampistas = "Equilibrado";

                if(binding.checkApoyarAtaque.isChecked()) centrocampistas = "Apoyar en ataque";

                if(binding.checkApoyarDefensa.isChecked()) centrocampistas ="Apoyar en defensa";

                if(binding.checkEquilibrado5.isChecked()) delanteros = "Equilibrado";

                if (binding.checkQuedarseArriba.isChecked()) delanteros = "Quedarse arriba";

                if (binding.checkBajarADefender.isChecked()) delanteros = "Bajar a defender";

                nombreT = binding.nombreTactica.getText().toString();

                db.collection("users").document(mAuth.getUid()).collection("tacticas").add(new Tactica(ataque,defensa,laterales,centrocampistas,delanteros,formacion,nombreT));
                navController.navigate(R.id.action_tacticasEleccionFragment_to_tacticas1Fragment);
            }
        });


    }
}