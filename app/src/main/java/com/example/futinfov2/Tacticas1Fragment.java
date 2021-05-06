package com.example.futinfov2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentRegisterBinding;
import com.example.futinfov2.databinding.FragmentTacticas1Binding;
import com.example.futinfov2.databinding.FragmentTacticasOfensivasBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;
import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class Tacticas1Fragment extends Fragment {

    private FragmentTacticas1Binding binding;
    private NavController navController;
    // FragmentTacticasOfensivasBinding fragmentTacticasOfensivasBinding;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;
    private TacticasViewModel tacticasViewModel;


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
        PushDownAnim.setPushDownAnimTo( binding.imageButton3)
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
}