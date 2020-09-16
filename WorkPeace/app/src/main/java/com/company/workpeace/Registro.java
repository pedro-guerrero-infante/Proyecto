package com.company.workpeace;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class Registro extends AppCompatActivity {
    TextInputLayout nombre;
    TextInputLayout email;
    TextInputLayout clave;
    Button btnRegistrarse;

    FirebaseDatabase ruta;
    DatabaseReference referencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre = findViewById(R.id.nombreRegistro);
        email = findViewById(R.id.emailRegistro);
        clave = findViewById(R.id.claveRegistro);
        btnRegistrarse = findViewById(R.id.btnRegistro);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruta = FirebaseDatabase.getInstance();
                referencia = ruta.getReference("Usuarios");


                String nombres =nombre.getEditText().getText().toString();
                String mail =email.getEditText().getText().toString();
                String contrasenia =clave.getEditText().getText().toString();

                UsuariosAux aux = new UsuariosAux(nombres,mail,contrasenia);
                referencia.child(nombres).setValue(aux);
                Intent i = new Intent(Registro.this,Perfil.class);
                startActivity(i);
            }
        });





    }
}