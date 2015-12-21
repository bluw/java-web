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
 
@FacesValidator("emailValidator")
public class EmailValidator implements Validator {
 
    @Override
    public void validate(FacesContext fc, UIComponent c, Object value) throws ValidatorException {
           String email = (String) value;
           String language = (String) c.getValueExpression("userLanguage").getValue(fc.getELContext());
           FacesMessage msg;
           if((!email.contains("@")) || (!email.contains(".")) || (email.length() < 6 && email.length() > 50)) {
               if(language.equals("fr")) {
                   msg = new FacesMessage("L'email doit contenir entre 4 et 50 charactères et contenir @ et un point.");
               } else {
                   msg = new FacesMessage("Email must contain between 4 and 50 characters and contains @ and a dot.");
               }
               throw new ValidatorException(msg);
           }
    }
}
