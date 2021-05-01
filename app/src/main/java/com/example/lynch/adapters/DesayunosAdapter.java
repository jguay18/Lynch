package com.example.lynch.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lynch.R;
import com.example.lynch.models.desayuno;

import java.util.ArrayList;

public class DesayunosAdapter extends RecyclerView.Adapter<DesayunosAdapter.ViewHolder>{
    private ArrayList<desayuno> desayunoArrayList;

    public DesayunosAdapter(ArrayList <desayuno> DesayunosArrayList) {
        this.desayunoArrayList = DesayunosArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgdesayuno;
        public TextView txtnombre;
        public TextView txtdescripcion;
        public TextView txtprecio;

        public ViewHolder (View itemView){
            super (itemView);
            imgdesayuno = itemView.findViewById(R.id.imgdesayuno);
            txtnombre = itemView.findViewById(R.id.txtnombre);
            txtdescripcion= itemView.findViewById(R.id.txtdescripcion);
            txtprecio = itemView.findViewById(R.id.txtprecio);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_desayuno,parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        desayuno desayuno = desayunoArrayList.get(position);
        holder.txtnombre.setText(desayuno.getComida());
        holder.txtdescripcion.setText(desayuno.getDescripcion());
        holder.txtprecio.setText(desayuno.getPrecio());
        holder.imgdesayuno.setImageResource(desayuno.getImagen());
    }

    @Override
    public int getItemCount() {
        return desayunoArrayList.size();
    }

}
