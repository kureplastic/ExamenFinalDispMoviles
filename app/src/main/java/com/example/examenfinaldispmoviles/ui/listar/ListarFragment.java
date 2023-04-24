package com.example.examenfinaldispmoviles.ui.listar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;


import com.example.examenfinaldispmoviles.NavigationActivityViewModel;
import com.example.examenfinaldispmoviles.databinding.FragmentListarBinding;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private NavigationActivityViewModel compartirPrueba;
    private FragmentListarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        compartirPrueba =  new ViewModelProvider(requireActivity()).get(NavigationActivityViewModel.class);
        ListarViewModel listarViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //armar grilla
        GridLayoutManager grilla = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        binding.rvListaNotas.setLayoutManager(grilla);

        //observer en la lista global
        compartirPrueba.getMutableNotasGlobales().observe(getViewLifecycleOwner(), new Observer<ArrayList<Double>>() {
            @Override
            public void onChanged(ArrayList<Double> notas) {
                //adapter para el recycler
                ListarAdapter adapter =new ListarAdapter(getContext(), getLayoutInflater(), notas);
                binding.rvListaNotas.setAdapter(adapter);
            }
        });

        //observer
        /*
        listarViewModel.getMutableNotas().observe(getViewLifecycleOwner(), new Observer<ArrayList<Double>>() {
            @Override
            public void onChanged(ArrayList<Double> notas) {
                //adapter para el recycler
                ListarAdapter adapter =new ListarAdapter(getContext(), getLayoutInflater(), notas);
                binding.rvListaNotas.setAdapter(adapter);
            }
        });

         */
        return root;
    }
}