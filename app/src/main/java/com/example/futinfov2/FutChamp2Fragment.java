package com.example.futinfov2;

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

import com.example.futinfov2.databinding.FragmentFutChamp2Binding;
import com.example.futinfov2.databinding.FragmentFutchamps1Binding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;


public class FutChamp2Fragment extends Fragment {

    private FragmentFutChamp2Binding binding;
    private NavController navController;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private TacticasViewModel tacticasViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentFutChamp2Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);

        PushDownAnim.setPushDownAnimTo( binding.button1)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button1.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button2)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button2.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button3)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button3.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button4)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button4.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button4)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button4.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button5)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button5.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button6)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button6.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button7)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button7.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button8)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button13.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button8)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button13.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button9)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button9.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button10)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button10.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button11)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button11.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button12)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button12.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button13)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button13.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button14)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button14.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button15)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button15.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button16)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button16.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button17)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button17.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo(binding.button18)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button18.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button19)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button19.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button20)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button20.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button21)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button21.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button22)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button22.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button23)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button23.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button24)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button24.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button25)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button25.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button26)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button26.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button27)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button27.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button28)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button28.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button29)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button29.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.button30)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setPartidoMutableLiveData((String) binding.button30.getText());
                        navController.navigate(R.id.action_futChamp2Fragment_to_futChamps3Fragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo( binding.guardar)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tacticasViewModel.setNombreMutableLiveData( binding.editText2.getText().toString());
                        FutChamps futChamps = new FutChamps(binding.editText2.getText().toString());
                        db.collection("users").document(mAuth.getUid()).collection("futChamps").add(futChamps);
                    }
                });

    }
}