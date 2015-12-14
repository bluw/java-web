/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerManagedBeans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author admin
 */
@FacesConverter("ledBooleanConverter")
public class LedBooleanConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent c, Object value) {
        String language = (String) c.getValueExpression("userLanguage").getValue(fc.getELContext());
        String msg;
        Boolean led = (Boolean) value;
        if (language.equals("fr")) {
            if (led == true) {
                msg = "OUI";
            } else {
                msg = "NON";
            }
        } else {
            if (led == true) {
                msg = "YES";
            } else {
                msg = "NO";
            }
        }
        return msg;
    }
    
}
