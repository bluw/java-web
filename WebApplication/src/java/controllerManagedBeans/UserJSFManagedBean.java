/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerManagedBeans;



import businessSessionBeans.websiteSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import model.CategoryM;
import model.ClientM;
import model.CountryM;
import model.KeyboardM;

/**
 *
 * @author etu26227
 */
@Named(value = "userManager")
@SessionScoped
public class UserJSFManagedBean implements Serializable {
    @EJB
    private websiteSessionBeanLocal websiteSessionBean;

    
    public String login()
    {
        try {
            client = websiteSessionBean.getAccount(email, password, language);
            isLogged = true;
            return "home";
        } catch (Exception e){
            isLogged = false;
            return "errorLoginPage";
        }
    }
    
    public String loadLanguage(String lang) 
    {
        setLanguage(lang);
        try {
            categoryList = websiteSessionBean.getListCategory(language);
            countryList = websiteSessionBean.getListCountry(language);
            return null;
        } catch (Exception e) {
            return "errorPage";
        }
    }
    
    public String search() {
        return "keyboardListPage";
    }
    
    public String register() 
    {       
        try {
            client.setCountry(country);
            websiteSessionBean.addClient(client);
            return "home";
            
        } catch (Exception e) {
            return "errorRegisterPage";
        }
    }
     
    
    public String addArticle(int id)
    {
        int nb = Integer.parseInt(nbArticle);
           
        cart.put(id, nb);
        
        return "keyboardListPage";
    }


      
    public List<KeyboardM> findKeyboardListByCategory()
    {
        try {
            keyboardList = websiteSessionBean.getListKeyboard(categoryLabel);
            return keyboardList;
            //return websiteSessionBean.getListKeyboard(categoryLabel);
        } catch (Exception e) {
            return null;
        } 
    }
    
    public List<KeyboardM> getKeyboardFromCart()
    {
        try {
            keyboardListInCart = websiteSessionBean.getListKeyboardFromCart(cart);   
            return keyboardListInCart;
        } catch (Exception e) {
            return null;
        }
    }
        
    
    public double computeSubTotal(double price, int quantity)
    {
        double subTotalPrice =(price * quantity);
        return subTotalPrice;
    }
    
    public double computeTotal(){
        double total = 0;
        for(KeyboardM k : keyboardListInCart) {
            total += k.getPrice() * ((int)cart.get(k.getId()));
        }
        
        if(client.getCountry() != null) {
            total+= client.getCountry().getShippingCost();
        }
        
        //PROMOTION : 10% OFF if total > 500
        if (total > 500.00) {
            total-= (total * 0.1);
        }
        
        return total;
    }
    
    
    public String addOrder() {
        try {
            int idOrder = websiteSessionBean.addOrders(client.getId());
            websiteSessionBean.addLineOrders(idOrder, cart);

            return "home";
        } catch (Exception e) {
            return "errorPage";
        }
    }
    
            
    public String takeOffOneArticle(int id) {
        int quantity = (int) cart.get(id);
        if(quantity == 1) {
            cart.remove(id);
        } else {
            cart.replace(id, --quantity);
        }
        return "shoppingCart";
    }
    
    public String deleteArticle(int id){
        cart.remove(id);
        return "shoppingCart";
    }
    
    public String viewDetails(KeyboardM keyboard)
    {
        keyboardToDisplay = keyboard;
        return "keyboardDetails";
    }
    
    /* GETTORS AND SETTORS ATTRIBUTE ETC*/    
    
    private ClientM client;
    private CountryM country;
    private Boolean isLogged;
    private String email;
    private String password;
    private String passwordCheck;
    private String language;
    private List<CategoryM> categoryList;
    private List<CountryM> countryList;
    private String nbArticle;
    private HashMap cart;
    private List<KeyboardM> keyboardList;
    private String categoryLabel;
    private List<KeyboardM> keyboardListInCart;
    private KeyboardM keyboardToDisplay;
    
    
    @PostConstruct
    public void init()
    {  
        client = new ClientM();
        country = new CountryM();
        isLogged = false;
        cart = new HashMap();
        loadLanguage("fr");
    }
    
    
    public UserJSFManagedBean() {
    }

    public ClientM getClient() {
        return client;
    }

    public void setClient(ClientM client) {
        this.client = client;
    }

    public Boolean getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
        
    }

    public List<CategoryM> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryM> categoryList) {
        this.categoryList = categoryList;
    }

    public List<CountryM> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryM> countryList) {
        this.countryList = countryList;
    }
    
    public String getNbArticle() {
        return nbArticle;
    }

    public void setNbArticle(String nbArticle) {
        this.nbArticle = nbArticle;
    }

    public HashMap getCart() {
        return cart;
    }

    public void setCart(HashMap cart) {
        this.cart = cart;
    }

    public CountryM getCountry() {
        return country;
    }

    public void setCountry(CountryM country) {
        this.country = country;
    }

    public List<KeyboardM> getKeyboardList() {
        return keyboardList;
    }

    public void setKeyboardList(List<KeyboardM> keyboardList) {
        this.keyboardList = keyboardList;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public List<KeyboardM> getKeyboardListInCart() {
        return keyboardListInCart;
    }

    public void setKeyboardListInCart(List<KeyboardM> keyboardListInCart) {
        this.keyboardListInCart = keyboardListInCart;
    }

    public KeyboardM getKeyboardToDisplay() {
        return keyboardToDisplay;
    }

    public void setKeyboardToDisplay(KeyboardM keyboardToDisplay) {
        this.keyboardToDisplay = keyboardToDisplay;
    }


}
