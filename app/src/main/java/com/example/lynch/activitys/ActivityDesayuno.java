package com.example.lynch.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lynch.R;
import com.example.lynch.adapters.DesayunosAdapter;
import com.example.lynch.models.desayuno;

import java.util.ArrayList;

public class ActivityDesayuno extends AppCompatActivity {

    private ArrayList<desayuno> DesayunosArrayList;
    private RecyclerView recyclerdesayuno;
    private DesayunosAdapter DesayunosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desayuno);
        recyclerdesayuno = findViewById(R.id.recyclerDesayuno);
//region Ingreso de Desayunos
        DesayunosArrayList = new ArrayList<>();

        desayuno  campecino = new desayuno();
        campecino.setComida("campecino");
        campecino.setDescripcion("Huevos al gusto con unas tostaras fritas " );
        campecino.setPrecio("Q15.00");
        campecino.setImagen(R.drawable.campecino);
        DesayunosArrayList.add(campecino);


        desayuno sandwich = new desayuno();
        sandwich.setComida("campecino");
        sandwich.setDescripcion("Huevos al gusto con unas tostaras fritas " );
        sandwich.setPrecio("Q15.00");
        sandwich.setImagen(R.drawable.sandwich);
        DesayunosArrayList.add(sandwich);

        desayuno divorsiado = new desayuno();
        divorsiado.setComida("Huevos divorsiados");
        divorsiado.setDescripcion("Huevos divorsiados con salsa verde y roja");
        divorsiado.setPrecio("Q25.00");
        divorsiado.setImagen(R.drawable.divorsiados);
        DesayunosArrayList.add(divorsiado);

        desayuno homelet = new desayuno();
        homelet.setComida("Homelet");
        homelet.setDescripcion("Homelet relleno con jamon salchicha argentina");
        homelet.setPrecio("Q50.00");
        homelet.setImagen(R.drawable.homelet);
        DesayunosArrayList.add(homelet);
//endregion

        DesayunosAdapter = new DesayunosAdapter(DesayunosArrayList);

        RecyclerView.LayoutManager manager = new LinearLayoutManager( this);
        recyclerdesayuno.setLayoutManager(manager);
        recyclerdesayuno.setItemAnimator(new DefaultItemAnimator());
        recyclerdesayuno.setAdapter(DesayunosAdapter);
    }
}