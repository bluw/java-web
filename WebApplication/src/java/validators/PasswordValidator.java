/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 
@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {
     
    @Override
    public void validate(FacesContext fc, UIComponent c, Object value){
        String passwordCheck = (String) value;
        String language = (String) c.getValueExpression("userLanguage").getValue(fc.getELContext());
        String password = (String) c.getAttributes().get("password");
        FacesMessage msg;
        
        if(password == null || passwordCheck == null) {            
            return; //let lengthValidator or required take care of it 
        }   
        
        if (!password.equals(passwordCheck)) {
            if (language.equals("fr")) {
                msg = new FacesMessage("Les mots de passes sont différents !");
            } else {
                msg = new FacesMessage("The passwords are different !");
            }
            throw new ValidatorException(msg);
        }

    }
}
