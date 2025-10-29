package com.Josuu1.zenvestprueba2;

import com.google.android.material.textfield.TextInputLayout;

public class FormUtils {
    /**
     * fun verifyUserName(til: TextInputLayout): Boolean{
     *     return til.editTest?.text.tString().isEmpty();
     * }
     */
    public boolean isTILEmpty(TextInputLayout textInputLayout){
        return String.valueOf(textInputLayout.getEditText().getText()).isEmpty();
    }

}
