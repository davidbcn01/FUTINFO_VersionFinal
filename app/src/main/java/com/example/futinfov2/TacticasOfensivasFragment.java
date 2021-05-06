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

import com.example.futinfov2.databinding.FragmentTacticasOfensivasBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class TacticasOfensivasFragment extends Fragment {
    private FragmentTacticasOfensivasBinding binding;


    private FirebaseFirestore db;
    private FirebaseAuth auth;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentTacticasOfensivasBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        TacticasViewModel tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);

        tacticasViewModel.getBoton().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.equals("433(4)")){
                    getTacticas("0HSEgeF4kqZ2WkmtdTKh");

                }
                if (s.equals("433(3)")){
                    getTacticas("7Ns423jBwKFUGvVmez2w");

                }
                if (s.equals("433(2)")){
                    getTacticas("IDeH0yRgXtGlwwSXjls2");
                }
                if (s.equals("433")){
                    getTacticas("h9PUz6HBBzuIYGfKqBMl");
                }
                if (s.equals("4231")){
                    getTacticas("pEpztR0uXIDi5dR4pYyW");
                }
                if (s.equals("4231(2)")){
                    getTacticas("aIWmfThNzFW5MgZL9MCM");
                }
                if (s.equals("532")){
                    getTacticas("YBmz1wj38ens5UYxE3SC");
                }
                if (s.equals("523")){
                    getTacticas("Y71t6xtatsHOQmPQgxna");
                }
                if (s.equals("41212")){
                    getTacticas("kH1eadEwWQBpdcQuuO9X");
                }
                if (s.equals("4141")){
                    getTacticas("GdkhbubJNfl2ciVhyXjV");
                }
                if (s.equals("4141(2)")){
                    getTacticas("oBZTGB93AlbHSg1r7dgL");
                }
                if (s.equals("442(2)")){
                    getTacticas("0eBkMc6LascNas8gzb1F");
                }


            }
        });

        }

    private void getTacticas(String document) {
        db.collection("tacticas").document(document).addSnapshotListener(((value, error) -> {
            Tactica tactica = new Tactica(value.getString("ataque"), value.getString("defensa"), value.getString("laterales"), value.getString("centrocampistas"), value.getString("delanteros"), value.getString("formacion"));
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
