package com.example.futinfov2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.futinfov2.databinding.ActivityMainBinding;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(false)
                .build();
        FirebaseFirestore.getInstance().setFirestoreSettings(settings);



        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.logInFragment || destination.getId() == R.id.splashScreenFragment || destination.getId() == R.id.registerFragment || destination.getId() == R.id.changePasswordFragment) {
                binding.bottomNavView.setVisibility(View.GONE);

            } else {
                binding.bottomNavView.setVisibility(View.VISIBLE);

            }
        });
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.logInFragment || destination.getId() == R.id.splashScreenFragment || destination.getId() == R.id.registerFragment || destination.getId() == R.id.changePasswordFragment || destination.getId() == R.id.inicioFragment) {

                binding.inicio.setVisibility(View.GONE);
            } else {
                binding.inicio.setVisibility(View.VISIBLE);
            }
        });
        binding.inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            navController.navigate(R.id.inicioFragment);
            }
        });

    }

}