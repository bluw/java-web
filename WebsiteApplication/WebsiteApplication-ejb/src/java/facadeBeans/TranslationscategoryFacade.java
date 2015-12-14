/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Translationscategory;
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
public class TranslationscategoryFacade extends AbstractFacade<Translationscategory> implements TranslationscategoryFacadeLocal {
    @PersistenceContext(unitName = "WebsiteApplication-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TranslationscategoryFacade() {
        super(Translationscategory.class);
    }

    @Override
    public List<Translationscategory> findCategoryTranslationByLanguage(String language) {
        Query query = em.createNamedQuery("Translationscategory.findCategoryTranslationByLanguage");
        query.setParameter("lang", language);
           
        return query.getResultList();
    }

}
