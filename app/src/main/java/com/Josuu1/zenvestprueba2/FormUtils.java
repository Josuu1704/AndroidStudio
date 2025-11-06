package com.Josuu1.zenvestprueba2;

import com.google.android.material.textfield.TextInputLayout;
import org.mindrot.jbcrypt.BCrypt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormUtils {
    public boolean isTILEmpty(TextInputLayout textInputLayout) {
        return String.valueOf(textInputLayout.getEditText().getText()).isEmpty();
    }

    public String getTILText(TextInputLayout textInputLayout) {
        return String.valueOf(textInputLayout.getEditText().getText());
    }

    public String generateHashedPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String candidate, String hashed) {
        return BCrypt.checkpw(candidate, hashed);
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }
}
