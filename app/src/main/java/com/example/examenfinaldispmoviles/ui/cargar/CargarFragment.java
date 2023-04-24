package com.example.examenfinaldispmoviles.ui.cargar;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.examenfinaldispmoviles.NavigationActivityViewModel;
import com.example.examenfinaldispmoviles.databinding.ActivityNavigationBinding;
import com.example.examenfinaldispmoviles.databinding.FragmentCargarBinding;
import com.example.examenfinaldispmoviles.ui.listar.ListarViewModel;

public class CargarFragment extends Fragment {

    private NavigationActivityViewModel compartirPrueba;
    private FragmentCargarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        compartirPrueba = new ViewModelProvider(requireActivity()).get(NavigationActivityViewModel.class);

        CargarViewModel cargarViewModel =
                new ViewModelProvider(this).get(CargarViewModel.class);

        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarViewModel.pasarNota(getContext(),binding.etNota.getText().toString(), compartirPrueba);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}