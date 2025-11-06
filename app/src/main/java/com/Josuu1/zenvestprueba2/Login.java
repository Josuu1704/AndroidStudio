package com.Josuu1.zenvestprueba2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

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
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button loginButton = findViewById(R.id.LoginButton);
        TextView loginTVRegister = findViewById(R.id.LoginTVRegister);
        TextInputLayout loginUserNameTIL = findViewById(R.id.LoginTILuserName);
        TextInputLayout loginPasswordTIL = findViewById(R.id.LoginTILpassword);
        FormUtils formUtils = new FormUtils();

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String hashedPassword = sharedPref.getString("password", "");
        Log.d("hashedPassword", hashedPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean canContinue = true;
                if (formUtils.isTILEmpty(loginUserNameTIL)) {
                    loginUserNameTIL.setErrorEnabled(true);
                    loginUserNameTIL.setError("Necesitas acceder con un nombre de usuario.");
                    canContinue = false;
                }
                if (formUtils.isTILEmpty(loginPasswordTIL)) {
                    loginPasswordTIL.setErrorEnabled(true);
                    loginPasswordTIL.setError("La contraseña está vacía.");
                    canContinue = false;
                } else if (!formUtils.checkPassword(formUtils.getTILText(loginPasswordTIL), hashedPassword)) {
                    loginPasswordTIL.setErrorEnabled(true);
                    loginPasswordTIL.setError("La contraseña es incorrecta.");
                    canContinue = false;
                }
                if (canContinue) {
                    Intent intentMain = new Intent(Login.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nombre", String.valueOf(loginUserNameTIL.getEditText().getText()));
                    intentMain.putExtras(bundle);
                    startActivity(intentMain);
                }
            }
        });


        loginTVRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(Login.this, Register.class);
                startActivity(intentRegister);
            }
        });
    }
}