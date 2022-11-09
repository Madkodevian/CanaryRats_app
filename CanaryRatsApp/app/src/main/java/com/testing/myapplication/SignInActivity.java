package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class SignInActivity extends AppCompatActivity {

    private TextView firstSurname;
    private TextView secondSurname;
    private TextView address;
    private TextView email;
    private TextView addPassword;
    private TextView repeatPassword;
    private Button buttonSignIn;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        //Localizar los controles
        name = findViewById(R.id.name);
        firstSurname = findViewById(R.id.firstSurname);
        secondSurname = findViewById(R.id.secondSurname);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        addPassword = findViewById(R.id.addPassword);
        repeatPassword = findViewById(R.id.repeatPassword);

        buttonSignIn = findViewById(R.id.buttonSignIn);




        //Error name
        TextInputLayout txtErrorName = findViewById(R.id.txtErrorName);
        txtErrorName.setErrorEnabled(true);

        //Recuperamos la información pasada en el intent
        //Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        //txtComprobar.setText("Ha iniciado sesión, usuario " + bundle.getString("EMAIL"));

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override

            //public void manejador (View boton)
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(SignInActivity.this, LoginActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }




}