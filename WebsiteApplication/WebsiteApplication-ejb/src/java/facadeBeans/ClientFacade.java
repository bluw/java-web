/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Client;
import entityBeans.Country;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ClientM;

/**
 *
 * @author admin
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    @PersistenceContext(unitName = "WebsiteApplication-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
    @Override
    public Client findLogin(String email, String password) throws Exception
    {
        try {
            Query query = em.createNamedQuery("Client.findLogin");
            query.setParameter("email", email);
            query.setParameter("password", password);
            return (Client)query.getSingleResult();
        } catch (Exception e){
            throw new Exception();
        }
    }
    
    @Override
    public void addClient(Client client) throws Exception
    {  
        try {
            em.persist(client);
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
}
