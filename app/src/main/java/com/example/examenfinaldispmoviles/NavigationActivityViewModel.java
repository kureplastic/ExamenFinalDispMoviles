package com.example.examenfinaldispmoviles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class NavigationActivityViewModel extends ViewModel {

    private  ArrayList<Double> notasGlobales;
    private MutableLiveData<ArrayList<Double>> mutableNotasGlobales;

    public NavigationActivityViewModel(){
        mutableNotasGlobales = new MutableLiveData<>();
        notasGlobales = new ArrayList<>();
        mutableNotasGlobales.setValue(notasGlobales);
    }

    public LiveData<ArrayList<Double>> getMutableNotasGlobales() {
        return mutableNotasGlobales;
    }

    public void addNotaMutable(Double nota){
        notasGlobales.add(nota);
        mutableNotasGlobales.setValue(notasGlobales);
    }
}
