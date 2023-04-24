package com.example.examenfinaldispmoviles.ui.listar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinaldispmoviles.R;

import java.util.ArrayList;

public class ListarAdapter extends RecyclerView.Adapter<ListarAdapter.ViewHolder>{

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Double> notas;

    public ListarAdapter(Context context, LayoutInflater inflater, ArrayList<Double> notas) {
        this.context = context;
        this.inflater = inflater;
        this.notas = notas;
    }

    @NonNull
    @Override
    public ListarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.item_nota,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ListarAdapter.ViewHolder holder, int position) {
        holder.tvNotaValor.setText(notas.get(position).toString());
        Log.d("adapter","entro nota: " + notas.get(position) );
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNota, tvNotaValor;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvNota = itemView.findViewById(R.id.tvNota);
            tvNotaValor = itemView.findViewById(R.id.tvNotaValor);
        }
    }
}
