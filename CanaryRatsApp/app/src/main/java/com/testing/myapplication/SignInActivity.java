package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity {

    private TextView name;
    private TextView firstSurname;
    private TextView secondSurname;
    private TextView address;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        //Localizar los controles
        name = findViewById(R.id.name);
        firstSurname = findViewById(R.id.firstSurname);
        secondSurname = findViewById(R.id.secondSurname);
        address = findViewById(R.id.address);
        buttonNext = findViewById(R.id.buttonNext);

        //Errores String (quitando email y password) = String vacia

        //Error name
        TextInputLayout txtErrorName = findViewById(R.id.txtErrorName);
        txtErrorName.setErrorEnabled(true);

        //Error first surname
        TextInputLayout txtErrorFirstSurname = findViewById(R.id.txtErrorFirstSurname);
        txtErrorFirstSurname.setErrorEnabled(true);

        //Error second surname no

        //Error address
        TextInputLayout txtErrorAddress = findViewById(R.id.txtErrorAddress);
        txtErrorAddress.setErrorEnabled(true);

        //Recuperamos la información pasada en el intent
        //Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        //txtComprobar.setText("Ha iniciado sesión, usuario " + bundle.getString("EMAIL"));

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override

            //public void manejador (View boton)
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(SignInActivity.this, SignInNextActivity.class);


                //Creamos la información a pasar entre actividades
                //bundle para el password
                Bundle bundleName = new Bundle();
                bundleName.putString("NAME", name.getText().toString());

                //Creamos la información a pasar entre actividades
                Bundle bundlefirstSurname = new Bundle();
                bundlefirstSurname.putString("FIRSTSURNAME", firstSurname.getText().toString());

                //Recogemos el texto recogido en una variable
                //email
                String userName = name.getText().toString();
                //password
                String userFirstSurname = firstSurname.getText().toString().trim();

                //Set error email and password
                if(userName.isEmpty()) {
                    txtErrorName.setError("Error: el nombre no es válido");
                }else{
                    txtErrorName.setError(null);
                    bundleName.putString("NAME", userName);

                    //clave-dato
                    //Añadimos la información al intent

                    intent.putExtras(bundleName);

                    //Iniciamos la nueva actividad
                    startActivity(intent);
                }
            }
        });
    }
}