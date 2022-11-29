package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

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
                //bundle para el name
                Bundle bundleSignIn = new Bundle();
                bundleSignIn.putString("NAME", name.getText().toString());

                //bundle para el first surname
                bundleSignIn.putString("FIRSTSURNAME", firstSurname.getText().toString());

                //bundle para el second surname
                bundleSignIn.putString("SECONDSURNAME", secondSurname.getText().toString());

                //bundle para el address
                bundleSignIn.putString("ADDRESS", address.getText().toString());

                //Recogemos el texto recogido en una variable
                //name
                String userName = name.getText().toString().trim();

                //first surname
                String userFirstSurname = firstSurname.getText().toString().trim();

                //second surname
                String userSecondSurname = secondSurname.getText().toString().trim();

                //address
                String userAddress = address.getText().toString().trim();

                //Set error email and password
                if(userName.isEmpty() || userFirstSurname.isEmpty() || userAddress.isEmpty()) {
                    txtErrorName.setError("Error: el nombre no es válido");
                    txtErrorFirstSurname.setError("Error: el primer apellido no es válido");
                    txtErrorAddress.setError("Error: la dirección no es válida");
                }else{
                    txtErrorName.setError(null);
                    txtErrorFirstSurname.setError(null);
                    txtErrorAddress.setError(null);
                    bundleSignIn.putString("NAME", userName);

                    //clave-dato
                    //Añadimos la información al intent

                    intent.putExtras(bundleSignIn);

                    //Iniciamos la nueva actividad
                    startActivity(intent);
                }
            }
        });
    }
}