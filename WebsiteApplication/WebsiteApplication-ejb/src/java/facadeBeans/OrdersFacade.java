/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Orders;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Order;

/**
 *
 * @author admin
 */
@Stateless
public class OrdersFacade extends AbstractFacade<Orders> implements OrdersFacadeLocal {
    @PersistenceContext(unitName = "WebsiteApplication-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }
    
    @Override
    public void addOrder(Orders order) throws Exception {
         try {
            em.persist(order);
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    @Override
    public Orders findLast() throws Exception {
        try {
            Query query = em.createNamedQuery("Orders.findLast");
            query.setMaxResults(1);
            return (Orders) query.getSingleResult();
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    
}
