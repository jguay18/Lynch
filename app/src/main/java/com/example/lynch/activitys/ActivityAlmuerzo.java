package com.example.lynch.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lynch.R;
import com.example.lynch.adapters.AlmuerzosAdapter;
import com.example.lynch.models.almuerzos;

import java.util.ArrayList;

public class ActivityAlmuerzo extends AppCompatActivity {

    private ArrayList<almuerzos> almuerzoArrayList;
    private RecyclerView recicleralmuerzo;
    private AlmuerzosAdapter almuerzosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almuerzo);
        recicleralmuerzo = findViewById(R.id.RecyclerAlmuerzos);
//region ingreso de almuerzos
        almuerzoArrayList = new ArrayList<>();

        almuerzos chomein = new almuerzos();
        chomein.setComida("Fajitas de Pollo");
        chomein.setDescripcion("Ricas Fajitas de pollo" );
        chomein.setPrecio("Q25.00");
        chomein.setImagen(R.drawable.chomein);

        almuerzoArrayList.add(chomein);

        almuerzos antojitos = new almuerzos();
        antojitos.setComida("antojitos");
        antojitos.setDescripcion("Rico pescado frito acompañado con una ensalada de aguacate");
        antojitos.setPrecio("Q50.00");
        antojitos.setImagen(R.drawable.antojito);
        almuerzoArrayList.add(antojitos);

        almuerzos horneado = new almuerzos();
        horneado.setComida("Pollo Horneado");
        horneado.setDescripcion("Pollo horneado con salsa especial acompañado con pure de papa y arroz al gusto");
        horneado.setPrecio("Q50.00");
        horneado.setImagen(R.drawable.pollohorneado);

        almuerzoArrayList.add(horneado);

        almuerzos revolcado = new almuerzos();
        revolcado.setComida("Revolcado");
        revolcado.setDescripcion("Rico revolcado acompañado con arroz");
        revolcado.setPrecio("Q50.00");
        revolcado.setImagen(R.drawable.revolcado);

        almuerzoArrayList.add(revolcado);
//endregion

        almuerzosAdapter = new AlmuerzosAdapter(almuerzoArrayList);

        RecyclerView.LayoutManager manager = new LinearLayoutManager( this);
        recicleralmuerzo.setLayoutManager(manager);
        recicleralmuerzo.setItemAnimator(new DefaultItemAnimator());
        recicleralmuerzo.setAdapter(almuerzosAdapter);
    }
}