package com.example.lynch.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lynch.R;
import com.example.lynch.models.almuerzos;

import java.util.ArrayList;

public class AlmuerzosAdapter extends RecyclerView.Adapter<AlmuerzosAdapter.ViewHolder> {
    private ArrayList<almuerzos> almuerzoArrayList;

    public AlmuerzosAdapter(ArrayList <almuerzos> almuerzoArrayList) {
        this.almuerzoArrayList = almuerzoArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgcomida;
        public TextView txtNombre;
        public TextView txtDescripcion;
        public TextView txtprecio;

        public ViewHolder(View itemView){
            super (itemView);
            imgcomida = itemView.findViewById(R.id.imgcomida);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtDescripcion= itemView.findViewById(R.id.txtDescripcion);
            txtprecio = itemView.findViewById(R.id.txtPrecio);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_almuerzo,parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlmuerzosAdapter.ViewHolder holder, int position) {
        almuerzos almuerzo = almuerzoArrayList.get(position);
        holder.txtNombre.setText(almuerzo.getComida());
        holder.txtDescripcion.setText(almuerzo.getDescripcion());
        holder.txtprecio.setText(almuerzo.getPrecio());
        holder.imgcomida.setImageResource(almuerzo.getImagen());
    }

    @Override
    public int getItemCount() {
        return almuerzoArrayList.size();
    }
}
