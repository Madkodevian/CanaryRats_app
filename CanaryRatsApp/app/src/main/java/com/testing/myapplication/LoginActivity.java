package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText userEmail;
    private EditText userPassword;
    private Button loginOrSignIn;
    private Button buttonWithoutLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Obtenemos una referencia a los controles de la interfaz
        userEmail = findViewById(R.id.userEmail);

        userPassword = findViewById(R.id.userPassword);

        loginOrSignIn = findViewById(R.id.loginOrSignIn);

        buttonWithoutLogin = findViewById(R.id.buttonWithoutLogin);

        TextInputLayout txtInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        txtInputLayout.setErrorEnabled(true);

        //Implementamos el evento click del botón
        loginOrSignIn.setOnClickListener(new View.OnClickListener() {
            @Override

            //public void manejador (View boton)
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(LoginActivity.this, LoginInActivity.class);

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();

                //SET ERROR EMAIL
                String correo = userEmail.getText().toString();

                if(correo.isEmpty() || !isValidEmail(correo)) {
                    txtInputLayout.setError("Error: el correo no es válido");
                }else if((correo.isEmpty())!=true && (!userPassword.getText().toString().trim().equals(""))) {
                    txtInputLayout.setError(null);
                    b.putString("EMAIL", correo);

                    /**
                     if(isValidEmail(userEmail.getText().toString())){
                     b.putString("EMAIL", userEmail.getText().toString());
                     }else{
                     System.out.println("El correo no es válido");
                     }
                     */

                    /** COMPROBAR SI EL EMAIL DADO ANTERIORMENTE, ES EL CORRECTO PARA INICIAR SESION
                     private boolean validarEmail(String email) {
                     Pattern pattern = Patterns.EMAIL_ADDRESS;
                     return pattern.matcher(email).matches();
                     }

                     if (!comprobarEmail(userEmail.getText().toString())){
                     userEmail.setError("Email no válido");
                     }
                     */

                    //Otro bundle para la edad
                    Bundle password = new Bundle();
                    password.putString("PASSWORD", userPassword.getText().toString());

                    //clave-dato
                    //Añadimos la información al intent
                    intent.putExtras(b);

                    //Iniciamos la nueva actividad
                    startActivity(intent);
                }
            }


            //Comprueba si el email es valido para ser una direccion de correo
            public boolean isValidEmail(CharSequence target) {
                return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
            }

            /**
            // Ocultar teclado virtual
            InputMethodManager imm =
                    (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

             //"v" es la instancia del view que inicia la entrada.
             */
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
    }
}