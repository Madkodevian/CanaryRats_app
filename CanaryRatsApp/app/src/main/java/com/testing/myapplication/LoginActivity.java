package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText userEmail;
    private EditText userPassword;
    private Button loginOrSignIn;
    private Button buttonWithoutLogin;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Obtenemos una referencia a los controles de la interfaz
        userEmail = findViewById(R.id.userEmail);

        userPassword = findViewById(R.id.userPassword);

        loginOrSignIn = findViewById(R.id.loginOrSignIn);

        buttonWithoutLogin = findViewById(R.id.buttonWithoutLogin);

        registrar = findViewById(R.id.registrar);

        //Error email
        TextInputLayout txtErrorEmail = findViewById(R.id.txtErrorEmail);
        txtErrorEmail.setErrorEnabled(true);

        //Error password
        TextInputLayout txtErrorPassword = findViewById(R.id.txtErrorPassword);
        txtErrorPassword.setErrorEnabled(true);

        //Recuperamos la información de SignInNextActivity pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        //txtComprobar.setText("usuario: " + bundle.getString("EMAIL"));

        //Implementamos el evento click del botón
        loginOrSignIn.setOnClickListener(new View.OnClickListener() {
            @Override

            //public void manejador (View boton)
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(LoginActivity.this, LoginInActivity.class);

                //info en consola
                Log.e("prueba", "estoy aqui");

                //Bundle login
                Bundle bundleLogin = new Bundle();

                //Recogemos el texto recogido en una variable
                //email
                String email = userEmail.getText().toString();
                //password
                String passwordLogin = userPassword.getText().toString().trim();

                //Bundle sign in
                String emailUser = bundleLogin.getString("EMAIL");
                String passwordUser = bundleLogin.getString("PASSWORD");

                //Sign in
                String name = bundle.getString("NAME");

                //Sign in next
                String emailSignIn = bundle.getString("EMAIL");
                String passwordSignIn = bundle.getString("PASSWORD");

                //Set error email and password
                if(email.isEmpty() || !email.equals(emailSignIn)) {
                    txtErrorEmail.setError("Error: el correo no es válido");
                }else if(passwordLogin.isEmpty() || !passwordLogin.equals(passwordSignIn)) {
                    txtErrorPassword.setError("Error: La contraseña no es válida");
                }else{
                    txtErrorEmail.setError(null);
                    txtErrorPassword.setError(null);
                    bundleLogin.putString("EMAIL", email);

                    //clave-dato
                    //Añadimos la información al intent
                    intent.putExtras(bundleLogin);

                    //Iniciamos la nueva actividad
                    startActivity(intent);
                }
            }
        });

        //Implementamos el evento click del botón
        buttonWithoutLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            //public void manejador (View boton)
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(LoginActivity.this, ShopActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(LoginActivity.this, SignInActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}
