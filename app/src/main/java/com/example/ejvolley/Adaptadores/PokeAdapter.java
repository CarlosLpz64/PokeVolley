package com.example.ejvolley.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejvolley.Clases.Pokemon;
import com.example.ejvolley.R;

import java.util.List;

public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.ViewHolder> implements View.OnClickListener  {

    //LISTA
    private List<Pokemon> Lista;
    public PokeAdapter(List<Pokemon> lista) {
        Lista = lista;
    }
    //ONCLICK
    private View.OnClickListener listener;

    @NonNull
    @Override
    public PokeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.disenorv, null, false);
        //ONCLICK
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PokeAdapter.ViewHolder holder, int position) {
        Pokemon pokemon = Lista.get(position);
        holder.bind(pokemon);
    }

    @Override
    public int getItemCount() {
        return Lista.size();
    }

    //MÉTODO ONCLICK
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Nombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre=itemView.findViewById(R.id.txt1);
        }

        public void bind(Pokemon pokemon) {
            Nombre.setText(pokemon.getName());
        }
    }
}
