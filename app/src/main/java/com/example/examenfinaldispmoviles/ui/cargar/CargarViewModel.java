package com.example.examenfinaldispmoviles.ui.cargar;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.examenfinaldispmoviles.NavigationActivityViewModel;

public class CargarViewModel extends AndroidViewModel {

    private Context context;

    public CargarViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
    
    public boolean verificarNota(String nota){
        if(nota.equals("")){
            Toast.makeText(context, "LA NOTA ESTA VACIA", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void pasarNota(Context contexto, String nota, NavigationActivityViewModel compartirPrueba){
        if(verificarNota(nota)) {
            compartirPrueba.addNotaMutable(Double.parseDouble(nota));
            Toast.makeText(contexto, "SE AGREGO LA NOTA!", Toast.LENGTH_SHORT).show();
        }
    }
}