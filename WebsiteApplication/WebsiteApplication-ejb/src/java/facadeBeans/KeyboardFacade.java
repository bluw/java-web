/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Keyboard;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
@Stateless
public class KeyboardFacade extends AbstractFacade<Keyboard> implements KeyboardFacadeLocal {
    @PersistenceContext(unitName = "WebsiteApplication-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KeyboardFacade() {
        super(Keyboard.class);
    }
    
    
    @Override
    public List<Keyboard> findByCategory(String labelCategory)
    {
        Query query = em.createNamedQuery("Keyboard.findByCategory");
        query.setParameter("label", labelCategory);
        return query.getResultList();
    }
    
}
