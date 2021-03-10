package view.fieldValidation;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class InputText extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        // TODO Auto-generated method stub
        return ((JTextField)input).getText().trim().length() > 0;
    }
    
}
