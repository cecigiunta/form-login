package com.example.tp1_formlogin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.EditText
import android.widget.TextView
import androidx.core.util.PatternsCompat
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<View>(R.id.boton)

        btn.setOnClickListener(){
            val editEmail = findViewById<EditText>(R.id.edit_email)
            val validation = findViewById<TextView>(R.id.invalid_text)
            val password = findViewById<EditText>(R.id.edit_pass)

            val email: String? = editEmail.getText().toString()
            val contra: String? = password.getText().toString()

            //Expresiones regulares para validar contraseña:
            val passwordRegex = Pattern.compile(
                "^" +
                        "(?=.*[0-9])" +     //al menos un digito
                        "(?=.*[a-z])" +     //al menos una minuscula
                        "(?=.*[A-Z])" +    //al menos una mayúscula
                        " (?=.*[^.])"+     //Ningun otro caracter aparte de los que defini
                        "(?=\\S+$)" +      //sin espacios en blanco
                        ".{8,}"  +      //al menos 8 caracteres
                        "$"
            )

            if(email?.isEmpty() == true || contra?.isEmpty() == true){
                validation.text = "Quedan campos vacíos, por favor verificar"
            }

            //VALIDACION DEL EMAIL
            else if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
                validation.text = "Correo electrónico inválido, por favor verificar"
            }

            //VALIDACION DE PASSWORD
            else if(!passwordRegex.matcher(contra).matches()) {
                validation.text = "Contraseña inválida, por favor verificar"
            } else {
                validation.setTextColor(Color.parseColor("#06701D"))
                validation.text="¡Ingreso exitoso!"
            }
        }
    }
}

