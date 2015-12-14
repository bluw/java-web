/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessSessionBeans;

import entityBeans.*;
import facadeBeans.*;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.*;

/**
 *
 * @author admin
 */
@Stateless
public class websiteSessionBean implements websiteSessionBeanLocal {
    @EJB
    private LineordersFacadeLocal lineordersFacade;
    @EJB
    private OrdersFacadeLocal ordersFacade;
    @EJB
    private ClientFacadeLocal clientFacade;
    @EJB
    private KeyboardFacadeLocal keyboardFacade;
    @EJB
    private TranslationscountryFacadeLocal translationscountryFacade;
    @EJB
    private TranslationscategoryFacadeLocal translationscategoryFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List<CategoryM> getListCategory(String language) throws Exception {
        try {
            List<Translationscategory> listFromDB = translationscategoryFacade.findCategoryTranslationByLanguage(language);
            List<CategoryM> list = new ArrayList();
            for(Translationscategory category : listFromDB) {
                CategoryM definitiveCat = new CategoryM();
                definitiveCat.setLabelnTranslated(category.getDescription());
                definitiveCat.setLabel(category.getFkCategory().getLabel());
                list.add(definitiveCat);
            }
            return list; 
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    @Override
    public int CountTest() {
        return translationscategoryFacade.count();
    }

    @Override
    public List<CountryM> getListCountry(String language) throws Exception {
        try {
            List<Translationscountry> listFromDB = translationscountryFacade.findCountryTranslationByLanguage(language);
            List<CountryM> list = new ArrayList();
            for(Translationscountry country : listFromDB) {
                CountryM definitiveCtry = new CountryM();
                definitiveCtry.setNameTranslated(country.getDescription());
                definitiveCtry.setShippingCost(country.getFkCountry().getShippingcost().doubleValue());
                definitiveCtry.setLabel(country.getFkCountry().getLabel());
                list.add(definitiveCtry);
            }
            return list;
            
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public List<KeyboardM> getListKeyboard(String categoryLabel) throws Exception {
        try {
            List<Keyboard> keyboardListFromCategory = keyboardFacade.findByCategory(categoryLabel);
            List<KeyboardM> list = new ArrayList();
            for (Keyboard keyboard : keyboardListFromCategory) {
                KeyboardM definitiveKb = new KeyboardM();
            
                definitiveKb.setName(keyboard.getKeyboardname());
                definitiveKb.setPrice(keyboard.getPrice().doubleValue());
                definitiveKb.setWeight(keyboard.getWeight().doubleValue());
                definitiveKb.setLed(keyboard.getLed());
                definitiveKb.setLongeur(keyboard.getLongeur().doubleValue());
                definitiveKb.setLayout(keyboard.getLayout());
                definitiveKb.setSwitches(keyboard.getSwitches());
                definitiveKb.setId(keyboard.getIdKeyboard());
                definitiveKb.setBrand(keyboard.getBrand());

                list.add(definitiveKb);
            }
            return list;
            
        } catch (Exception e){
            throw new Exception();
        }
    }

    @Override
    public void addClient(ClientM client) throws Exception {
        Client clientToDB = new Client();
        clientToDB.setLastname(client.getLastName());
        clientToDB.setFirstname(client.getFirstName());
        clientToDB.setEmail(client.getEmail());
        String cryptedPassword = myCrypt(client.getPassword());
        clientToDB.setPassword(cryptedPassword);
        clientToDB.setPhone(client.getPhone());
        clientToDB.setStreet(client.getStreet());
        clientToDB.setHousenum((short)client.getHouseNum());
        clientToDB.setCity(client.getCity());
        clientToDB.setPostcode(client.getPostCode());
        
        Country fkCountry = new Country();
        fkCountry.setLabel(client.getCountry().getLabel());
        clientToDB.setFkCountry(fkCountry);
       
        try {
            clientFacade.create(clientToDB);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public ClientM getAccount(String email, String password, String language) throws Exception {
        try {
            String cryptedPassword = myCrypt(password);
            Client client = clientFacade.findLogin(email, cryptedPassword);
        
            ClientM definitiveClient = new ClientM();
            definitiveClient.setLastName(client.getLastname());
            definitiveClient.setFirstName(client.getFirstname());
            definitiveClient.setEmail(client.getEmail());
            definitiveClient.setPhone(client.getPhone());
            definitiveClient.setStreet(client.getStreet());
            definitiveClient.setHouseNum(client.getHousenum());
            definitiveClient.setCity(client.getCity());
            definitiveClient.setPostCode(client.getPostcode());
            definitiveClient.setId(client.getIdClient());
        
            //fill country Object in Client
            CountryM country = new CountryM();    
            country.setLabel(client.getFkCountry().getLabel());
            country.setShippingCost(client.getFkCountry().getShippingcost().doubleValue());         
            //find translation to country
            Translationscountry countryFromDB = translationscountryFacade.findCountryNameTranslated(language, country.getLabel());
            country.setNameTranslated(countryFromDB.getDescription());
        
            definitiveClient.setCountry(country);
            return definitiveClient;
            
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    @Override
    public List<KeyboardM> getListKeyboardFromCart(HashMap cart) throws Exception
    {
        try {
            List<KeyboardM> list = new ArrayList();
            Iterator iterator = cart.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry me = (Map.Entry)iterator.next();
                Keyboard kbFromDB = keyboardFacade.find(me.getKey());
                KeyboardM kb = new KeyboardM();
                kb.setBrand(kbFromDB.getBrand());
                kb.setLayout(kbFromDB.getLayout());
                kb.setLed(kbFromDB.getLed());
                kb.setName(kbFromDB.getKeyboardname());
                kb.setPrice(kbFromDB.getPrice().doubleValue());
                kb.setSwitches(kbFromDB.getSwitches());
                kb.setId(kbFromDB.getIdKeyboard());

                list.add(kb);
            }
            
            return list;
        } catch (Exception e) {
            throw new Exception();
            
        }   
    }

    @Override
    public int addOrders(int idClient) throws Exception {
        Date currentDate = new Date();
        Orders orderToDB = new Orders();
        orderToDB.setOrdersdate(currentDate);
        
        Client fkClient = new Client();
        fkClient.setIdClient(idClient);
        orderToDB.setFkClient(fkClient);
        
        try {
            ordersFacade.addOrder(orderToDB);
            Orders lastOrder = ordersFacade.findLast(); //need idOrder to create LineOrders linked to this Order
            return lastOrder.getIdOrders();
        } catch (Exception e) {
            throw new Exception();
        } 
    }
    
    @Override
    public void addLineOrders(int idOrder, HashMap cart) throws Exception 
    {
     
            Iterator iterator = cart.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry me = (Map.Entry)iterator.next();
            
                Lineorders line = new Lineorders();
                Integer qt = (Integer) me.getValue();
                line.setQuantity(qt.shortValue());
                Keyboard kbFromDB = keyboardFacade.find(me.getKey());
                line.setPrice(kbFromDB.getPrice());
                line.setFkKeyboard(kbFromDB);
                Orders fkOrder = new Orders();
                fkOrder.setIdOrders(idOrder);
                line.setFkOrders(fkOrder);
            
                lineordersFacade.addLineOrders(line);
            }
 
    }
    
    
    
    private String myCrypt (String password) throws NoSuchAlgorithmException{
            StringBuffer hexString = new StringBuffer();
            try{
                //Create MD5 Hash
                MessageDigest digest = MessageDigest.getInstance("SHA-512");
                digest.update(password.getBytes());
                byte messageDigest[] = digest.digest();

                //Create Hex String
                for (int i=0; i<messageDigest.length; i++) {
                    String h = Integer.toHexString(0xFF & messageDigest[i]);
                    while (h.length() < 2) {
                        h = "0" + h;
                        hexString.append(h);
                    }
                }
                return hexString.toString();
            }catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
            return "";
        }
    
}
