package com.example.lynch.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lynch.R;
import com.example.lynch.adapters.CenasAdapter;
import com.example.lynch.models.cena;

import java.util.ArrayList;

public class ActivityCena extends AppCompatActivity {

    private ArrayList<cena> cenaArrayList;
    private RecyclerView recyclerCena;
    private CenasAdapter cenasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cena);
        recyclerCena = findViewById(R.id.recyclerCenas);

        cenaArrayList = new ArrayList<>();

        cena frijol = new cena("Frijoles colorados", "Frijoles colorados con carne de pollo o res como a uste le guste mas",
                "Q15.00",R.drawable.frijoles);
        cenaArrayList.add(frijol);

        cena hilachas = new cena("Hilachas","Hilachas acompañadas con arroz",
                "Q25.00",R.drawable.hilachas);
        cenaArrayList.add(hilachas);

        cena barbacoa = new cena("Pollo en Barbacoa", "Pollo bañado en barbacoa acompañado con pure de papa",
                "Q25.00",R.drawable.barbacoa);
        cenaArrayList.add(barbacoa);




        cenasAdapter = new CenasAdapter(cenaArrayList);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);

        recyclerCena.setLayoutManager(manager);
        recyclerCena.setItemAnimator(new DefaultItemAnimator());
        recyclerCena.setAdapter(cenasAdapter);
    }
    
}