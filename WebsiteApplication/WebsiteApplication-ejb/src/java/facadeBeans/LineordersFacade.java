/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Lineorders;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class LineordersFacade extends AbstractFacade<Lineorders> implements LineordersFacadeLocal {
    @PersistenceContext(unitName = "WebsiteApplication-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineordersFacade() {
        super(Lineorders.class);
    }
    
    @Override
    public void addLineOrders(Lineorders line) throws Exception {
         try {
            em.persist(line);
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
