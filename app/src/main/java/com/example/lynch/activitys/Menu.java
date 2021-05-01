package com.example.lynch.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lynch.R;
import com.example.lynch.sesion.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class Menu extends AppCompatActivity {
    CircleMenu circleMenu;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        circleMenu = findViewById(R.id.cicle_menu);
        constraintLayout = findViewById(R.id.constrainLayout);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.ic_baseline_add_24, R.drawable.ic_baseline_close_24);
        circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.drawable.ic_baseline_food_bank_24);
        circleMenu.addSubMenu(Color.parseColor("#30A400"), R.drawable.ic_almuerzo);
        circleMenu.addSubMenu(Color.parseColor("#FF4B32"), R.drawable.ic_diner);
        circleMenu.addSubMenu(Color.parseColor("#8A39FF"), R.drawable.ic_baseline_logout_24);
        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int index) {
                switch (index) {
                    case 0:
                        Toast.makeText(Menu.this, "Desayunos", Toast.LENGTH_SHORT).show();
                        constraintLayout.setBackgroundColor(Color.parseColor("#ecfffb"));
                        gotoDesayuno();
                        break;
                    case 1:
                        Toast.makeText(Menu.this, "Almuerzos", Toast.LENGTH_SHORT).show();
                        constraintLayout.setBackgroundColor(Color.parseColor("#96f7d2"));
                        gotoAlmuerzo();
                        break;
                    case 2:
                        Toast.makeText(Menu.this, "Cenas", Toast.LENGTH_SHORT).show();
                        constraintLayout.setBackgroundColor(Color.parseColor("#fac4a2"));
                        gotoCena();
                        break;
                    case 3:
                        Toast.makeText(Menu.this, "Cerrar sesión", Toast.LENGTH_SHORT).show();
                        constraintLayout.setBackgroundColor(Color.parseColor("#d3cde6"));
                        logout();
                        break;
                }
            }
        });
    }

    //region intents
    private void logout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    private void gotoAlmuerzo(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, ActivityAlmuerzo.class);
        startActivity(intent);
        return;
    }
    private void gotoDesayuno(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, ActivityDesayuno.class);
        startActivity(intent);
        return;
    }
    private void gotoCena(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, ActivityCena.class);
        startActivity(intent);
        return;
    }
    //endregion

}