package com.example.futinfov2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentChangePasswordBinding;
import com.example.futinfov2.databinding.FragmentCrearTuCartaBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static androidx.core.content.ContextCompat.checkSelfPermission;
import static androidx.core.content.PermissionChecker.PERMISSION_GRANTED;


public class CrearTuCartaFragment extends Fragment {

    private FragmentCrearTuCartaBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCrearTuCartaBinding.inflate(inflater, container, false)).getRoot();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.constraintLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(requireContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/cartas%2FtotwGrande.png?alt=media&token=d251ed9c-e017-4a69-8e5e-3a935b13f211")
                        .into(binding.carta);


            }
        });

        binding.constraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(requireContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/cartas%2FiconoGrande.png?alt=media&token=443a61ba-64c7-4574-b543-3f306ee2d5f0")
                        .into(binding.carta);

            }
        });
        binding.constraintLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(requireContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/futinfo-1b129.appspot.com/o/cartas%2ForoGrande.png?alt=media&token=4461e0df-7895-401d-8bfd-31dc5745cb4f")
                        .into(binding.carta);


            }
        });

        binding.descargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            captureView();
            }
        });
        binding.nation.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 abrirGaleria();
             }
            });
         }

    public void captureView(){
        //boolean saved;
        OutputStream fos;
        Bitmap image = Bitmap.createBitmap(binding.constraintLayout4.getWidth(),
                binding.constraintLayout4.getHeight(),
                Bitmap.Config.RGB_565);
        //Draw the view inside the Bitmap
        binding.constraintLayout4.draw(new Canvas(image));

        //Store to sdcard
        try {
            String dirImagen = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS).toString();
            File file = new File(dirImagen);
            if(!file.exists()){
                file.mkdir();
            }
            File imagen = new File(dirImagen,"Imagen.png");
            fos = new FileOutputStream(imagen);
             image.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.flush();
            fos.close();
            //String imagenGuardada = MediaStore.Images.Media.insertImage(getContentResolver)
            /*String path = Environment.getExternalStorageDirectory().toString();  // qutar esto
            File myFile = new File(path,filename);   // en lugar de new filoe, tienes usar createTempFile o algo así
            FileOutputStream out = new FileOutputStream(myFile);

            image.compress(Bitmap.CompressFormat.PNG, 90, out); //Output

             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void abrirGaleria() {
        if (checkSelfPermission(requireContext(), READ_EXTERNAL_STORAGE) == PERMISSION_GRANTED && checkSelfPermission(requireContext(),WRITE_EXTERNAL_STORAGE)==PERMISSION_GRANTED) {
            lanzadorGaleria.launch("image/*");
        } else {
            lanzadorPermisos.launch(WRITE_EXTERNAL_STORAGE);
            lanzadorPermisos.launch(READ_EXTERNAL_STORAGE);
        }
    }

    private final ActivityResultLauncher<String> lanzadorGaleria =
            registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
                if (uri != null) {
                  //  listaJugadoresViewModel.establecerImagenSeleccionada(uri.toString());
                }
            });

    private final ActivityResultLauncher<String> lanzadorPermisos =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    lanzadorGaleria.launch("image/*");
                }
            });

}