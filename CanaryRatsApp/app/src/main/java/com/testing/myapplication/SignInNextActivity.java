package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInNextActivity extends AppCompatActivity {

    private TextView userEmail;
    private TextView addPassword;
    private TextView repeatPassword;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_next);

        //Localizar los controles
        userEmail = findViewById(R.id.userEmail);
        addPassword = findViewById(R.id.addPassword);
        repeatPassword = findViewById(R.id.repeatPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);

        //Errores String (quitando email y password) = String vacia

        //Error email
        TextInputLayout txtErrorEmail = findViewById(R.id.txtErrorEmail);
        txtErrorEmail.setErrorEnabled(true);

        //Error add password
        TextInputLayout txtErrorAddPassword = findViewById(R.id.txtErrorAddPassword);
        txtErrorAddPassword.setErrorEnabled(true);

        //Error repeat password
        TextInputLayout txtErrorRepeatPassword = findViewById(R.id.txtErrorRepeatPassword);
        txtErrorRepeatPassword.setErrorEnabled(true);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override

            //public void manejador (View boton)
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(SignInNextActivity.this, LoginActivity.class);


                //Creamos la información a pasar entre actividades
                //bundle para el password
                Bundle bundleSignInNext = new Bundle();

                //Recogemos el texto recogido en una variable
                //email
                String email = userEmail.getText().toString().trim();
                //password
                String passwordLogin = addPassword.getText().toString().trim();
                //repeat password
                String passwordRepeatLogin = repeatPassword.getText().toString().trim();

                //Set error email and password
                if((!isValidEmail(email)) || email.isEmpty()) {
                    txtErrorEmail.setError("Error: el correo no es válido");
                }else if((!isValidPassword(passwordLogin)) || passwordLogin.isEmpty()) {
                    txtErrorAddPassword.setError("Error: La contraseña no es válida");
                    //txtErrorPassword.setError("Error: Intenta añadir una minúscula, una mayúscula, " +
                    //"un dígito y un caracter especial. De 8 a 20 caracteres.");
                    //Esto sería para hacer el registro
                }else if((email.isEmpty()) && (passwordLogin.isEmpty())) {
                    txtErrorAddPassword.setError("Error: la contraseña no es válida");
                    txtErrorEmail.setError("Error: el correo no es válido");
                }else if(!(passwordLogin.equals(passwordRepeatLogin))){
                    txtErrorRepeatPassword.setError("Error: la contraseña no es válida");
                }else if(passwordRepeatLogin.isEmpty()){
                    txtErrorRepeatPassword.setError("Error: la contraseña no es válida");
                }else{
                    txtErrorEmail.setError(null);
                    txtErrorAddPassword.setError(null);
                    txtErrorRepeatPassword.setError(null);
                    bundleSignInNext.putString("EMAIL", email);
                    bundleSignInNext.putString("PASSWORD", passwordLogin);

                    //clave-dato
                    //Añadimos la información al intent
                    intent.putExtras(bundleSignInNext);

                    //Iniciamos la nueva actividad
                    startActivity(intent);
                }
            }

            //Comprueba si el email es valido para ser una direccion de correo
            public boolean isValidEmail(CharSequence target) {
                return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
            }

            //Comprueba si el password es valido con las limitaciones que se tengan
            public Boolean isValidPassword(String password) {
                Pattern pattern;
                Matcher matcher;
                final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,20}$";
                //minimo 8, maximo 20
                pattern = Pattern.compile(PASSWORD_PATTERN);
                matcher = pattern.matcher(password);

                return matcher.matches();

                //^                 # start-of-string
                //(?=.*[0-9])       # a digit must occur at least once
                //(?=.*[a-z])       # a lower case letter must occur at least once
                //(?=.*[A-Z])       # an upper case letter must occur at least once
                //(?=.*[@#$%^&+=])  # a special character must occur at least once you can replace with your special characters
                //(?=\\S+$)          # no whitespace allowed in the entire string
                //.{4,}             # anything, at least six places though
                //.{de este minimo, a este maximo}
                //$                 # end-of-string
            }
            //The regex represents the need for user to enter at least 1 Uppercase, 1 Number and 1 Symbol
        });
    }
}