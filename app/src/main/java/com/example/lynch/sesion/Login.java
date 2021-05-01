package com.example.lynch.sesion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lynch.activitys.Menu;
import com.example.lynch.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private TextView edtlogin;
    private EditText txtEmail;
    private EditText txtPassword;
    private FloatingActionButton btnlogin ;
    private FirebaseAuth auth;
    private ConstraintLayout contenedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        ConeccionVistas();
        auth = FirebaseAuth.getInstance();
    }

    public void login(View view){
        if (!isEmpty(txtEmail)&& !isEmpty(txtPassword)){
            return;
        }else{
            String email = txtEmail.getText().toString();
            String password = txtPassword.getText().toString();
            loginwithEmailyPaswoord(email,password);
        }
    }
    private void loginwithEmailyPaswoord ( String email, String password){
    auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this, task -> {
                if (task.isSuccessful()){
                    Intent intent = new Intent(this, Menu.class);
                    startActivity(intent);
                    finish();
                }else{
                    Snackbar.make(contenedor, "Cuenta no extiste", Snackbar.LENGTH_LONG)
                            .setAction("Crear Cuenta", view ->{
                                Intent intent = new Intent(this, SingUp.class);
                                startActivity(intent);
                                finish();
                            }).show();
                }
            });
    }

    private boolean isEmpty(EditText editText){
        if (txtEmail.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo Correo Electronico esta vacio ", Toast.LENGTH_SHORT).show();
            return false;
        }else if(txtPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo Contraseña esta vacio", Toast.LENGTH_SHORT).show();
            return false;
        }return true;
    }


    public void launchSingup(View view){
        Intent launchSa = new Intent(this, SingUp.class);
        startActivity(launchSa);
    }

    private void ConeccionVistas(){
        edtlogin = findViewById(R.id.edtlogin);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnlogin = findViewById(R.id.btnlogin);
        contenedor = findViewById(R.id.contenedor);


    }

}