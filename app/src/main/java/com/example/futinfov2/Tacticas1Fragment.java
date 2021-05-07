package com.example.futinfov2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentRegisterBinding;
import com.example.futinfov2.databinding.FragmentTacticas1Binding;
import com.example.futinfov2.databinding.FragmentTacticasOfensivasBinding;
import com.example.futinfov2.databinding.ViewholderBotonTacticasBinding;
import com.example.futinfov2.databinding.ViewholderSbcBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.List;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;
import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class Tacticas1Fragment extends Fragment {

    private FragmentTacticas1Binding binding;
    private NavController navController;
    // FragmentTacticasOfensivasBinding fragmentTacticasOfensivasBinding;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;
    private TacticasViewModel tacticasViewModel;
    private List<Tactica> tacticasCreadas = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentTacticas1Binding.inflate(inflater, container, false)).getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        firebaseFirestore = FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();

        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);



        TacticasAdapter adapter = new TacticasAdapter();
        binding.recyclerView.setAdapter(adapter);
        firebaseFirestore.collection("users").document(mAuth.getUid()).collection("tacticas").addSnapshotListener((value, error) -> {
            tacticasCreadas.clear();
            value.forEach(document ->{
                tacticasCreadas.add(new Tactica(
                        document.getString("nombre")));
            });
            adapter.notifyDataSetChanged();
        });





        PushDownAnim.setPushDownAnimTo( binding.button1)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button1.getText());

                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);

            }
        });


        PushDownAnim.setPushDownAnimTo( binding.button2)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button2.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });



        PushDownAnim.setPushDownAnimTo( binding.button3)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button3.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });



        PushDownAnim.setPushDownAnimTo( binding.button4)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button4.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button5)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button5.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });


        PushDownAnim.setPushDownAnimTo( binding.button6)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button6.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });

        PushDownAnim.setPushDownAnimTo( binding.button10)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button10.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button20)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button20.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button30)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button30.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button40)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button40.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button50)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button50.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button60)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button60.getText());
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo(binding.imageButton3)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_tacticas1Fragment_to_tacticasFormacionFragment);
            }
        });
    }
    class TacticasViewHolder extends RecyclerView.ViewHolder {
        ViewholderBotonTacticasBinding binding;

        public TacticasViewHolder(ViewholderBotonTacticasBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    class TacticasAdapter extends RecyclerView.Adapter<TacticasViewHolder>{

        @NonNull
        @Override
        public TacticasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TacticasViewHolder(ViewholderBotonTacticasBinding.inflate(getLayoutInflater(),parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull TacticasViewHolder holder, int position) {
            Tactica tactica = tacticasCreadas.get(position);
            holder.binding.button1.setText(tactica.nombre);
            holder.binding.button1.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    tacticasViewModel.setBoton((String) holder.binding.button1.getText());
                    //guarda bien el valor con el set
                    navController.navigate(R.id.action_tacticas1Fragment_to_tacticasOfensivasFragment);
                }
            });

        }

        @Override
        public int getItemCount() {
            return tacticasCreadas.size();
        }
    }
}