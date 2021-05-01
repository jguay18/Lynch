  package com.example.lynch.sesion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lynch.activitys.Menu;
import com.example.lynch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SingUp extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseFirestore db;
    private EditText edtemail, edtpassword, edtNombre, edtuser, edtfechadenacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        getSupportActionBar().hide();
        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        ConeccionVistas();

    }

    public void login(View view){
        if (!isEmpty(edtemail)&&!isEmpty(edtfechadenacimiento)&&!isEmpty(edtNombre)&&!isEmpty(edtuser)&&!isEmpty(edtpassword)){
            return;
        }else{
            String email = edtemail.getText().toString();
            String password = edtpassword.getText().toString();
            registroEmailcontra(email,password);
        }
    }
    private void registroEmailcontra(String email, String password){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()){
                        FirebaseUser Usuario = auth.getCurrentUser();
                        guardar(Usuario.getUid());
                    }else{
                        Toast.makeText(this, "Error al crear la Cuenta", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //region guardar usuario
    private void guardar(String uid){
        Map<String, Object> data = new HashMap<>();
        data.put("correo", edtemail.getText().toString());
        data.put("fecha_de_nacimiento", edtfechadenacimiento.getText().toString());
        data.put("nombre", edtNombre.getText().toString());
        data.put("usuario", edtuser.getText().toString());

        db.collection("user").document(uid).set(data).addOnSuccessListener(success ->{
            Toast.makeText(this, "Cuenta Creada", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
            finish();
        })
        .addOnFailureListener(failure ->{
            Toast.makeText(this, "ERROR AL CREAR Dattos", Toast.LENGTH_SHORT).show();
        });

    }

    //endregion

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser Usuario = auth.getCurrentUser();
        if (Usuario !=null){
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
            finish();
        }
    }
    //region validacion
    private boolean isEmpty(EditText editText){
        if (edtNombre.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo Nombre esta vacio ", Toast.LENGTH_SHORT).show();
            return false;
        } else if(edtuser.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo Usuario esta vacio", Toast.LENGTH_SHORT).show();
            return false;
        }else if(edtemail.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo CorreO Electronico esta vacio", Toast.LENGTH_SHORT).show();
            return false;
        }else if(edtpassword.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo Contraseña esta vacio", Toast.LENGTH_SHORT).show();
            return false;
        }return true;
    }
    //endregion
    //region FECHA
    private void mostrarFecha(){
        Fechadefragmentos fechadefragmentos = Fechadefragmentos.newInstance((DatePicker, year ,month, day)->{
           final String Dateselected = day + "/" + (month+1) + "/" + year;
           edtfechadenacimiento.setText(Dateselected);
        });
        fechadefragmentos.show(getSupportFragmentManager(), "DATEPICKER");
    }
    public static class Fechadefragmentos extends DialogFragment{

        private DatePickerDialog.OnDateSetListener listener;

        public static Fechadefragmentos newInstance(DatePickerDialog.OnDateSetListener listener){
            Fechadefragmentos fragmento = new Fechadefragmentos();
            fragmento.setListener(listener);
            return fragmento;
        }

        public void setListener (DatePickerDialog.OnDateSetListener listener){
            this.listener = listener;
        }


        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), listener, year, month, day);
        }

    }
    // endregion
    //region vistas
    protected void ConeccionVistas(){
        edtNombre = findViewById(R.id.edtNombre);
        edtemail = findViewById(R.id.edtEmail);
        edtpassword = findViewById(R.id.edtpassword);
        edtuser = findViewById(R.id.edtuser);
        edtfechadenacimiento = findViewById(R.id.edtfechadenacimiento);
        edtfechadenacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarFecha();
            }
        });
    }


    //endregion

}