package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginInActivity extends AppCompatActivity {

    private TextView txtSaludoUsuario;
    private TextView textViewParrafo;
    private Button buttonShop;
    private Button buttonGetInTouch;
    private Button buttonProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginin);

        //Localizar los controles
        txtSaludoUsuario = findViewById(R.id.txtSaludoUsuario);
        textViewParrafo = findViewById(R.id.textViewParrafo);
        buttonShop = findViewById(R.id.buttonShop);
        buttonGetInTouch = findViewById(R.id.buttonGetInTouch);
        buttonProfile = findViewById(R.id.buttonProfile);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtSaludoUsuario.setText("Ha iniciado sesión, usuario " + bundle.getString("EMAIL"));

        textViewParrafo.setText("");





    }


}