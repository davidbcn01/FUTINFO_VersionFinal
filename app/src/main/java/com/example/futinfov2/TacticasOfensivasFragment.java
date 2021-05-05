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

import com.example.futinfov2.databinding.FragmentTacticas1Binding;
import com.example.futinfov2.databinding.FragmentTacticasOfensivasBinding;
import com.google.firebase.firestore.FirebaseFirestore;


public class TacticasOfensivasFragment extends Fragment {
    private FragmentTacticasOfensivasBinding binding;


    private FirebaseFirestore firebaseFirestore;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentTacticasOfensivasBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseFirestore = FirebaseFirestore.getInstance();

        TacticasViewModel tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);

        tacticasViewModel.getBoton().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.equals("433(4)")){
                    firebaseFirestore.collection("tacticas").document("0HSEgeF4kqZ2WkmtdTKh").addSnapshotListener(((value, error) ->{
                        Tactica tactica = new Tactica(value.getString("ataque"),value.getString("defensa"), value.getString("laterales"),value.getString("centrocampistas"),value.getString("delanteros"),value.getString("formacion"));
                        binding.formacionTactica.setText(tactica.formacion);
                        binding.ataque.setText(tactica.ataque);
                        binding.defensa.setText(tactica.defensa);
                        binding.laterales.setText(tactica.laterales);
                        binding.centrocampistas.setText(tactica.centrocampistas);
                        binding.delanteros.setText(tactica.delanteros);

                    }

                    ));

                }
                if (s.equals("433(3)")){
                    firebaseFirestore.collection("tacticas").document("7Ns423jBwKFUGvVmez2w").addSnapshotListener(((value, error) ->{
                        Tactica tactica = new Tactica(value.getString("ataque"),value.getString("defensa"), value.getString("laterales"),value.getString("centrocampistas"),value.getString("delanteros"),value.getString("formacion"));
                        binding.formacionTactica.setText(tactica.formacion);
                        binding.ataque.setText(tactica.ataque);
                        binding.defensa.setText(tactica.defensa);
                        binding.laterales.setText(tactica.laterales);
                        binding.centrocampistas.setText(tactica.centrocampistas);
                        binding.delanteros.setText(tactica.delanteros);

                    }

                    ));

                }
                if (s.equals("433(2)")){
                    firebaseFirestore.collection("tacticas").document("IDeH0yRgXtGlwwSXjls2").addSnapshotListener(((value, error) ->{
                        Tactica tactica = new Tactica(value.getString("ataque"),value.getString("defensa"), value.getString("laterales"),value.getString("centrocampistas"),value.getString("delanteros"),value.getString("formacion"));
                        binding.formacionTactica.setText(tactica.formacion);
                        binding.ataque.setText(tactica.ataque);
                        binding.defensa.setText(tactica.defensa);
                        binding.laterales.setText(tactica.laterales);
                        binding.centrocampistas.setText(tactica.centrocampistas);
                        binding.delanteros.setText(tactica.delanteros);

                    }

                    ));
                }
                if (s.equals("433")){
                    firebaseFirestore.collection("tacticas").document("h9PUz6HBBzuIYGfKqBMl").addSnapshotListener(((value, error) ->{
                        Tactica tactica = new Tactica(value.getString("ataque"),value.getString("defensa"), value.getString("laterales"),value.getString("centrocampistas"),value.getString("delanteros"),value.getString("formacion"));
                        binding.formacionTactica.setText(tactica.formacion);
                        binding.ataque.setText(tactica.ataque);
                        binding.defensa.setText(tactica.defensa);
                        binding.laterales.setText(tactica.laterales);
                        binding.centrocampistas.setText(tactica.centrocampistas);
                        binding.delanteros.setText(tactica.delanteros);

                    }

                    ));
                }

            }
        });

        }
    }
