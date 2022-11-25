package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginInActivity extends AppCompatActivity {

    private TextView txtSaludoUsuario;
    private TextView textViewParrafo;
    private ImageButton buttonShop;
    private ImageButton buttonGetInTouch;
    private ImageButton buttonProfile;


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

        textViewParrafo.setText("Éste es su perfil de Usuario. Para acceder a otras opciones, seleccione uno de los botones de abajo.");



        buttonShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(LoginInActivity.this, ShopActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

    }


}