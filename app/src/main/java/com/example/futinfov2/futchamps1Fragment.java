package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.futinfov2.databinding.FragmentFutchamps1Binding;
import com.example.futinfov2.databinding.FragmentTacticas1Binding;
import com.example.futinfov2.databinding.ViewholderBotonFutchampsBinding;
import com.example.futinfov2.databinding.ViewholderBotonTacticasBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.List;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;


public class futchamps1Fragment extends Fragment {

    private FragmentFutchamps1Binding binding;
    private NavController navController;

    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private TacticasViewModel tacticasViewModel;
    private List<FutChamps> futChampsCreados = new ArrayList<>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentFutchamps1Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        db = FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();

        tacticasViewModel = new ViewModelProvider(requireActivity()).get(TacticasViewModel.class);
        FutAdapter adapter = new FutAdapter();
        binding.recyclerView.setAdapter(adapter);
        db.collection("users").document(mAuth.getUid()).collection("futChamps").addSnapshotListener((value, error) -> {
            futChampsCreados.clear();
            value.forEach(document ->{
                futChampsCreados.add(new FutChamps(
                        document.getId(),
                        document.getString("nombre")));
            });
            adapter.notifyDataSetChanged();
        });

        PushDownAnim.setPushDownAnimTo(binding.button25)
                .setScale( MODE_SCALE, 0.89f  )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        navController.navigate(R.id.action_futchamps1Fragment_to_futChamp2Fragment);
                    }
                });
    }
    class FutChampsViewHolder extends RecyclerView.ViewHolder {
        ViewholderBotonFutchampsBinding binding;

        public FutChampsViewHolder(ViewholderBotonFutchampsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
    class FutAdapter extends RecyclerView.Adapter<FutChampsViewHolder>{

        @NonNull
        @Override
        public FutChampsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new FutChampsViewHolder(ViewholderBotonFutchampsBinding.inflate(getLayoutInflater(),parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull FutChampsViewHolder holder, int position) {
            FutChamps futChamps = futChampsCreados.get(position);

        holder.binding.button19.setText(futChamps.nombre);
            holder.binding.button19.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    tacticasViewModel.setIdSBC(futChamps.id);

                    navController.navigate(R.id.action_futchamps1Fragment_to_verFutChampsFragment);
                }
            });


        }

        @Override
        public int getItemCount() {
            return futChampsCreados.size();
        }
    }
}