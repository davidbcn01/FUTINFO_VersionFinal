package com.example.futinfov2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.futinfov2.databinding.FragmentObjetivosHitosBinding;
import com.example.futinfov2.databinding.ViewholderObjetivosNumBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ObjetivosHitosFragment extends Fragment {
    private NavController navController;
    private FirebaseFirestore db;
    private FragmentObjetivosHitosBinding binding;
    private FirebaseAuth mAuth;
    String id;
    String objColection;
    private List<Objetivo> objetivos = new ArrayList<>();
    private HashMap<String, String> conseguidos = new HashMap<>();   // <idSBC, valor>

    String coleccion;
    private ObjetivosAdapter objetivosAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentObjetivosHitosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);
        mAuth = FirebaseAuth.getInstance();
        TacticasViewModel tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);

        objetivosAdapter = new ObjetivosAdapter();
        binding.recyclerView.setAdapter(objetivosAdapter);

        tacticasViewModel.getIdSBC().observe(getViewLifecycleOwner(), idSBC -> {
            switch (idSBC) {
                case "Hitos":
                    id = "l2hk6bCEPEhoLwIfBqxf";
                    objColection = "hitos";
                    coleccion = idSBC;
                    binding.encabezado.setText(idSBC.toUpperCase());
                    break;
                case "Jugador de liga":
                    coleccion = idSBC;
                    id = "kz5BAjAL9T9zU0gHgCiF";
                    objColection = "liga";
                    binding.encabezado.setText(idSBC.toUpperCase());
                    break;
                case "Objetivos diarios":
                    coleccion = idSBC;
                    id = "PYOIkdC5n5m1QYob4EgD";
                    objColection = "objetivosDiarios";
                    binding.encabezado.setText(idSBC.toUpperCase());
                    break;
            }
            getObjetivos(id, objColection);
            showObjetivos(coleccion);
            binding.button16.setOnClickListener(v -> {
                setObjetivos(coleccion);
                navController.navigate(R.id.action_objetivosHitosFragment_to_objetivos1Fragment);
            });
        });


    }
/*
    public void captureView(int viewId,String filename){
        //Find the view we are after
              //Create a Bitmap with the same dimensions
        Bitmap image = Bitmap.createBitmap(binding.recyclerView.getWidth(),
                binding.recyclerView.getHeight(),
                Bitmap.Config.RGB_565);
        //Draw the view inside the Bitmap
        binding.recyclerView.draw(new Canvas(image));

        //Store to sdcard
        try {
            String path = Environment.getExternalStorageDirectory().toString();  // qutar esto
            File myFile = new File(path,filename);   // en lugar de new filoe, tienes usar createTempFile o algo así
            FileOutputStream out = new FileOutputStream(myFile);

            image.compress(Bitmap.CompressFormat.PNG, 90, out); //Output
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    private void setObjetivos(String colection) {
        conseguidos.entrySet().forEach(e -> {
            db.collection("users").document(mAuth.getUid()).collection(colection).document(e.getKey()).set(new Objetivo(e.getValue()));
        });
    }

    private void showObjetivos(String coleccion) {
        db.collection("users").document(mAuth.getUid()).collection(coleccion).addSnapshotListener((value, error) -> {
            conseguidos.clear();
            value.forEach(document -> {
                conseguidos.put(document.getId(), document.getString("progreso"));
            });
            /*conseguidos.entrySet().forEach(e -> {
            });

             */
            objetivosAdapter.notifyDataSetChanged();
        });
    }

    private void getObjetivos(String id, String coleccion) {
        db.collection("objetivos").document(id).collection(coleccion).addSnapshotListener((value, error) -> {
            objetivos.clear();
            value.forEach(document -> {
                objetivos.add(new Objetivo(document));
            });

            objetivosAdapter.notifyDataSetChanged();
        });
    }

    static class ObjViewHolder extends RecyclerView.ViewHolder {
        ViewholderObjetivosNumBinding binding;

        public ObjViewHolder(ViewholderObjetivosNumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class ObjetivosAdapter extends RecyclerView.Adapter<ObjViewHolder> {

        @NonNull
        @Override
        public ObjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ObjViewHolder(ViewholderObjetivosNumBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ObjViewHolder holder, int position) {
            Objetivo objetivo = objetivos.get(position);

            holder.binding.titulo.setText(objetivo.getTitulo());
            holder.binding.descrip.setText(objetivo.getDescripcion());
            holder.binding.reward.setText(objetivo.getRecompensa());
            holder.binding.objetivoNum.setText(objetivo.getObjetivo());

            holder.binding.editText.setTag("cualquiercosa");

            if (conseguidos.containsKey(objetivo.idSBCD)) {
                if ("".equals(conseguidos.get(objetivo.idSBCD))) {
                    holder.binding.editText.setText("0");
                } else {
                    holder.binding.editText.setText(conseguidos.get(objetivo.idSBCD));
                }
            } else {
                holder.binding.editText.setText("0");
            }

            holder.binding.editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(holder.binding.editText.getTag() == null){
                        conseguidos.put(objetivo.idSBCD, s.toString());
                    }
                    holder.binding.editText.setTag(null);
                }

                @Override
                public void afterTextChanged(Editable s) {
                    //holder.binding.editText.clearFocus();
                }
            });



        }

        @Override
        public int getItemCount() {
            return objetivos.size();
        }
    }
}

// objetivos  // a b c d e f g h i

// progreso { a : 10,  c: 3, h: 7 }