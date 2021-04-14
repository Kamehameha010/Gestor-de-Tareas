package com.cr.view.FieldValidation;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class InputText extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
    
        return ((JTextField)input).getText().trim().length() > 0;
    }
    
}
