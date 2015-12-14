/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Languages;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class LanguagesFacade extends AbstractFacade<Languages> implements LanguagesFacadeLocal {
    @PersistenceContext(unitName = "WebsiteApplication-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LanguagesFacade() {
        super(Languages.class);
    }
    
}
