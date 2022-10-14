package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LoginInActivity extends AppCompatActivity {

    private TextView txtComprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginin);

        //Localizar los controles
        txtComprobar = findViewById(R.id.txtComprobar);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtComprobar.setText("Ha iniciado sesión, usuario " + bundle.getString("EMAIL"));
    }


}