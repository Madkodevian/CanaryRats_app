package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
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

        //Error email
        TextInputLayout txtErrorEmail = findViewById(R.id.txtErrorEmail);
        txtErrorEmail.setErrorEnabled(true);

        //Error password
        TextInputLayout txtErrorPassword = findViewById(R.id.txtErrorPassword);
        txtErrorPassword.setErrorEnabled(true);

        //Implementamos el evento click del botón
        loginOrSignIn.setOnClickListener(new View.OnClickListener() {
            @Override

            //public void manejador (View boton)
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(LoginActivity.this, LoginInActivity.class);


                //Creamos la información a pasar entre actividades
                //bundle para el password
                Bundle bundlePassword = new Bundle();
                //bundlePassword.putString("PASSWORD", userPassword.getText().toString());

                //Creamos la información a pasar entre actividades
                Bundle bundleEmail = new Bundle();
                //bundleEmail.putString("EMAIL", userEmail.getText().toString());

                //Recogemos el texto recogido en una variable
                //email
                String email = userEmail.getText().toString();
                //password
                String passwordLogin = userPassword.getText().toString().trim();

                //Set error email and password
                if(email.isEmpty() || !isValidEmail(email)) {
                    txtErrorEmail.setError("Error: el correo no es válido");
                }else if((passwordLogin.isEmpty()) || !isValidPassword(passwordLogin)) {
                    txtErrorPassword.setError("Error: La contraseña no es válida");
                    //txtErrorPassword.setError("Error: Intenta añadir una minúscula, una mayúscula, " +
                    //        "un dígito y un caracter especial. De 8 a 20 caracteres.");
                    //Esto sería para hacer el registro
                }else{
                    txtErrorEmail.setError(null);
                    txtErrorPassword.setError(null);
                    bundleEmail.putString("EMAIL", email);
                    bundlePassword.putString("PASSWORD", passwordLogin);

                    //Hacer casos:
                    //1.Si el correo está vacío o no es valido
                    //2.Si la contraseña está vacía o no es válida

                    /** COMPROBAR SI EL EMAIL DADO ANTERIORMENTE, ES EL CORRECTO PARA INICIAR SESION
                     private boolean validarEmail(String email) {
                     Pattern pattern = Patterns.EMAIL_ADDRESS;
                     return pattern.matcher(email).matches();
                     }

                     if (!comprobarEmail(userEmail.getText().toString())){
                     userEmail.setError("Email no válido");
                     }
                     */

                    //clave-dato
                    //Añadimos la información al intent
                    intent.putExtras(bundleEmail);

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

            /**
            public boolean isValidPassword(String s) {
                Pattern PASSWORD_PATTERN
                        = Pattern.compile(
                        "[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");

                return !TextUtils.isEmpty(s) && PASSWORD_PATTERN.matcher(s).matches();
            }
             */


            /**
            // Mostrar teclado virtual
            userEmail.requestFocus(); //Asegurar que editText tiene focus
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(yourEditText, InputMethodManager.SHOW_IMPLICIT);

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