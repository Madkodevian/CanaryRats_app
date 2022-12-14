package com.testing.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class LoginActivity extends AppCompatActivity {

    private EditText userEmail;
    private EditText userPassword;
    private Button login;
    private Button buttonWithoutLogin;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Obtenemos una referencia a los controles de la interfaz
        userEmail = findViewById(R.id.userEmail);

        userPassword = findViewById(R.id.userPassword);

        login = findViewById(R.id.login);

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

        //Implementamos el evento click del botón
        login.setOnClickListener(new View.OnClickListener() {
            @Override

            //public void manejador (View boton)
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(LoginActivity.this, LoginInActivity.class);

                //informacion en consola de prueba
                //Log.e("prueba1", "estoy aqui");

                //Bundle login
                Bundle bundleLogin = new Bundle();

                //Recogemos el texto recogido en una variable
                //email
                String email = userEmail.getText().toString();
                //password
                String passwordLogin = userPassword.getText().toString().trim();

                //Sign in next
                String emailSignIn = bundle.getString("EMAIL");
                String passwordSignIn = bundle.getString("PASSWORD");

                //Set error email and password
                if (email.isEmpty() || !email.equals(emailSignIn)) {
                    txtErrorEmail.setError("Error: el correo no es válido");
                } else if (passwordLogin.isEmpty() || !passwordLogin.equals(passwordSignIn)) {
                    txtErrorPassword.setError("Error: La contraseña no es válida");
                } else {
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

    public void fade(View button){
        startActivity(new Intent(this, ShopActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
