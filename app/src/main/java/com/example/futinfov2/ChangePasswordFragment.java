package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.futinfov2.databinding.FragmentChangePasswordBinding;
import com.example.futinfov2.databinding.FragmentLogInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;


public class ChangePasswordFragment extends Fragment {

    private FragmentChangePasswordBinding binding;
    private NavController navController;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentChangePasswordBinding.inflate(inflater, container, false)).getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        mAuth = FirebaseAuth.getInstance();


        PushDownAnim.setPushDownAnimTo(binding.changePsw)
                .setScale(MODE_SCALE, 0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setOnClickListener(view1 -> {
                    String email = binding.changePasswordEmail.getText().toString();

                    mAuth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(task -> {//metodo para enviar email para resetear la contraseña
                                if (task.isSuccessful()) {
                                    Toast.makeText(requireActivity(), "Te hemos enviado un email", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show();
                                }
                            });
                    navController.navigate(R.id.action_changePasswordFragment_to_logInFragment);
                });
        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_changePasswordFragment_to_logInFragment);
            }
        });

    }

}
