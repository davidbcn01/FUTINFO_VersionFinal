package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ObjetivosHitosFragment extends Fragment {
    private NavController navController;
    private FirebaseFirestore db;
    private FragmentObjetivosHitosBinding binding;
    private FirebaseAuth mAuth;
    private List<Objetivo> objetivos = new ArrayList<>();
    private List<Objetivo> progreso = new ArrayList<>();
    private HashMap<String, String> conseguidos = new HashMap<>();   // <idSBC, valor>
    String coleccion;
    // 7db345df 56
    // Q8tdfsf  10
    // 3ry   98

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
        ObjetivosAdapter objetivosAdapter = new ObjetivosAdapter();

        binding.recyclerView.setAdapter(objetivosAdapter);
        System.out.println("onViewCreated");
        tacticasViewModel.getIdSBC().observe(getViewLifecycleOwner(), idSBC -> {
            switch (idSBC) {
                case "Hitos":
                    coleccion = idSBC;
                    binding.encabezado.setText(idSBC.toUpperCase());

                    db.collection("objetivos").document("l2hk6bCEPEhoLwIfBqxf").collection("hitos").addSnapshotListener((value, error) -> {
                        objetivos.clear();
                        value.forEach(document -> {
                            objetivos.add(new Objetivo(document));
                        });


                        objetivosAdapter.notifyDataSetChanged();
                    });

                    db.collection("users").document(mAuth.getUid()).collection(coleccion).addSnapshotListener((value, error) -> {
                        conseguidos.clear();
                        value.forEach(document -> {
                            conseguidos.put(document.getId(), document.getString("progreso"));
                        });
                        conseguidos.entrySet().forEach(e -> {
                            Log.e("ABCD", "entradas : " + e.getKey() + " -> " + e.getValue());
                        });
                        objetivosAdapter.notifyDataSetChanged();
                    });

                    binding.button16.setOnClickListener(v -> {
                        Log.e("ABCD", "boton click");
                        conseguidos.entrySet().forEach(e -> {
                            Log.e("ABCD", "entradas : " + e.getKey() + " -> " + e.getValue());
                            db.collection("users").document(mAuth.getUid()).collection(coleccion).document(e.getKey()).set(new Objetivo(e.getValue()));

                        });
                        navController.navigate(R.id.action_objetivosHitosFragment_to_objetivos1Fragment);

                    });

                    /*binding.button16.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            //te has quedado por aqui bobo
                        db.collection("users").document(mAuth.getUid()).collection("ObjetivosHitos");
                        }
                    });
                    */
                    break;
                case "Jugador de liga":
                    coleccion = idSBC;
                    binding.encabezado.setText(idSBC.toUpperCase());
                    db.collection("objetivos").document("kz5BAjAL9T9zU0gHgCiF").collection("liga").addSnapshotListener((value, error) -> {
                        objetivos.clear();
                        value.forEach(document -> {
                            objetivos.add(new Objetivo(document));
                        });
                        objetivosAdapter.notifyDataSetChanged();
                    });
                   /* db.collection("users").document(mAuth.getUid()).collection("objetivos").addSnapshotListener((value, error) -> {
                        conseguidos.clear();
                        value.forEach(document->{
                            conseguidos.put(document.getId(),document.getString("progreso"));
                        });
                        // meter todos los logros en el hashmap

                        objetivosAdapter.notifyDataSetChanged();
                    });
*/

                    break;
                case "Objetivos diarios":
                    coleccion = idSBC;
                    binding.encabezado.setText(idSBC.toUpperCase());
                    db.collection("objetivos").document("PYOIkdC5n5m1QYob4EgD").collection("objetivosDiarios").addSnapshotListener((value, error) -> {
                        objetivos.clear();
                        value.forEach(document -> {
                            objetivos.add(new Objetivo(document));
                        });
                        objetivosAdapter.notifyDataSetChanged();
                    });
                   /* db.collection("users").document(mAuth.getUid()).collection("objetivos").addSnapshotListener((value, error) -> {
                        conseguidos.clear();
                        value.forEach(document->{
                            conseguidos.put(document.getId(),document.getString("progreso"));
                        });
                        // meter todos los logros en el hashmap

                        objetivosAdapter.notifyDataSetChanged();
                    });
*/
                    break;
            }
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
            System.out.println("ABCD onBindView");
            Objetivo objetivo = objetivos.get(position);

            holder.binding.titulo.setText(objetivo.getTitulo());
            holder.binding.descrip.setText(objetivo.getDescripcion());
            holder.binding.reward.setText(objetivo.getRecompensa());
            holder.binding.objetivoNum.setText(objetivo.getObjetivo());
            holder.binding.editText.setText(objetivo.getProgreso());

//            hasmap.get(objetivo.idSBCD)


            if (conseguidos.containsKey(objetivo.idSBCD)) {
                System.out.println("ABCD " + "containskey");
                holder.binding.editText.setText(conseguidos.get(objetivo.idSBCD));
                // lo marco
            } else {
                System.out.println("ABCD " + "NOT  containskey");
                holder.binding.editText.setText(objetivo.progreso);
            }
            // si el objetivo no esta en el hasmap es que 0
            //

   /* Log.e("ABCD textchanged", "" + s);
                    if(!s.equals("0")){
                        conseguidos.put(objetivo.idSBCD, s.toString());
                    }
                    */
            holder.binding.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // si estaba marcado no guardo en el hashmap per lo dedsmarco
                    if (!hasFocus){
                        conseguidos.put(objetivo.idSBCD, holder.binding.editText.getText().toString());
                    }

                }


            });



                    //Objetivo obj = new Objetivo(objetivo.getTitulo(), objetivo.getDescripcion(),objetivo.getRecompensa(),objetivo.getObjetivo(),s.toString());
                    //db.collection("users").document(mAuth.getUid()).collection(coleccion).document(objetivo.idSBCD).set(obj);




           /* int progreso = Integer.parseInt(String.valueOf(holder.binding.editText.getText()));

           binding.button16.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Objetivo obj = new Objetivo(objetivo.getTitulo(),progreso);
                   db.collection("users").document(mAuth.getUid()).collection("objetivos").document(objetivo.idSBCD).set(obj);

               }
           });

*/


        }

        @Override
        public int getItemCount() {
            return objetivos.size();
        }
    }
}

// objetivos  // a b c d e f g h i

// progreso { a : 10,  c: 3, h: 7 }