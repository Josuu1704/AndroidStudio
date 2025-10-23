package com.Josuu1.zenvestprueba2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextInputLayout usernameTIL = findViewById(R.id.RegisterTILuserName);
        TextInputLayout passwordTIL = findViewById(R.id.RegisterTILpassword);
        TextInputLayout password2TIL = findViewById(R.id.RegisterTIL2password);
        TextInputLayout emailTIL = findViewById(R.id.RegisterTILemail);
        Button registerButton = findViewById(R.id.RegisterButton);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = String.valueOf(usernameTIL.getEditText().getText());
                String password = String.valueOf(passwordTIL.getEditText().getText());
                String password2 = String.valueOf(password2TIL.getEditText().getText());
                String email = String.valueOf(emailTIL.getEditText().getText());

                if(username.isEmpty()){
                    Toast brindis = Toast.makeText(Register.this, "El usuario está vacio", Toast.LENGTH_SHORT);
                    brindis.show();
            }
                if(password.isEmpty()){
                    Toast brindis = Toast.makeText(Register.this, "La contraseña está vacia", Toast.LENGTH_SHORT);
                    brindis.show();
                } else {
                    if(password2.isEmpty()){
                        Toast brindis = Toast.makeText(Register.this, "La contraseña está vacia", Toast.LENGTH_SHORT);
                        brindis.show();
                    } else {
                        if (!password.equals(password2)){
                            Toast brindis =  Toast.makeText(Register.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT);
                            brindis.show();
                        }
                    }
                }

                if(email.isEmpty()){
                    Toast brindis = Toast.makeText(Register.this, "El email está vacia", Toast.LENGTH_SHORT);
                    brindis.show();
                }

        }
        });

    }
}
