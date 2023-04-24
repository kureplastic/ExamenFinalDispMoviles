package com.example.examenfinaldispmoviles.ui.listar;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ListarViewModel extends AndroidViewModel {

    // no use nada de esto porque despues me di cuenta que cada vez que pasaba de un fragment al otro, se volvian a recrear dichos fragments
    // y las variables se volvian a inicializar.
    // Dicho esto me di cuenta que tenia guardar las notas en algun view model que no expirara en ningun momento
    // y decidi implementar el view model del navigation.
    private MutableLiveData <ArrayList<Double>> mutableNotas;

    private ArrayList<Double> notas;
    private Context context;

    public ListarViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        mutableNotas = new MutableLiveData<>();
        notas = new ArrayList<>();
        //cargar notas y el mutable
        notas.add(8.5);
        notas.add(9.0);
        notas.add(7.0);
        mutableNotas.setValue(notas);
    }

    public LiveData<ArrayList<Double>> getMutableNotas(){
        return mutableNotas;
    }


    public void AddNota(Double nota){
        notas.add(nota);
        mutableNotas.setValue(notas);
        Toast.makeText(context, "SE CARGO LA NOTA", Toast.LENGTH_SHORT).show();
    }

    public void recuperarNota(Bundle bundle){
        Double nota = bundle.getDouble("nota");
        AddNota(nota);
    }

}