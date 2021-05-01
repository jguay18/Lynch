package com.example.lynch.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lynch.R;
import com.example.lynch.models.cena;

import java.util.ArrayList;

public class CenasAdapter extends RecyclerView.Adapter<CenasAdapter.ViewHolder> {

    private ArrayList<cena> cenaArrayList;

    public CenasAdapter(ArrayList<cena> cenaArrayList){
        this.cenaArrayList = cenaArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgCena;
        public TextView txtcomida;
        public TextView txtDescripcion1;
        public TextView txtprice;

        public ViewHolder(View itemView){
            super(itemView);
            imgCena = itemView.findViewById(R.id.imgCena);
            txtcomida = itemView.findViewById(R.id.txtcomida);
            txtDescripcion1 = itemView.findViewById(R.id.txtDescripcion1);
            txtprice = itemView.findViewById(R.id.txtprice);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cena, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        cena cena = cenaArrayList.get(position);
        holder.txtcomida.setText(cena.getNombre());
        holder.txtDescripcion1.setText(cena.getDescripcion());
        holder.txtprice.setText(cena.getPrecio());
        holder.imgCena.setImageResource(cena.getImagen());
    }

    @Override
    public int getItemCount() { return cenaArrayList.size(); }
}
