/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessSessionBeans;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import model.*;

/**
 *
 * @author admin
 */
@Local
public interface websiteSessionBeanLocal {

    List<CategoryM> getListCategory(String language) throws Exception;

    int CountTest();

    List<CountryM> getListCountry(String language) throws Exception;

    List<KeyboardM> getListKeyboard(String categoryLabel) throws Exception;

    void addClient(ClientM client) throws Exception;

    ClientM getAccount(String email, String password, String language) throws Exception;

    List<KeyboardM> getListKeyboardFromCart(HashMap cart) throws Exception;
    
    int addOrders(int idClient) throws Exception;
    
    void addLineOrders(int idOrder, HashMap cart) throws Exception;
    
}
