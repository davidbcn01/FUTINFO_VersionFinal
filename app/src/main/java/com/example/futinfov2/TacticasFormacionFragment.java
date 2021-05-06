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

import com.example.futinfov2.databinding.FragmentTacticas1Binding;
import com.example.futinfov2.databinding.FragmentTacticasFormacionBinding;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class TacticasFormacionFragment extends Fragment {

    private FragmentTacticasFormacionBinding binding;
    private NavController navController;
    private TacticasViewModel tacticasViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentTacticasFormacionBinding.inflate(inflater, container, false)).getRoot();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);


        PushDownAnim.setPushDownAnimTo( binding.button1)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button1.getText());
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
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
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
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
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
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
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
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
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
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
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
            }
        });

        PushDownAnim.setPushDownAnimTo( binding.button7)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button7.getText());
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button8)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button8.getText());
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button9)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button9.getText());
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
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
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button11)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button11.getText());
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button12)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button12.getText());
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button13)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button13.getText());
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button14)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button14.getText());
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
            }
        });
        PushDownAnim.setPushDownAnimTo( binding.button15)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticasViewModel.setBoton((String) binding.button15.getText());
                navController.navigate(R.id.action_tacticasFormacionFragment_to_tacticasEleccionFragment);
            }
        });
    }
}