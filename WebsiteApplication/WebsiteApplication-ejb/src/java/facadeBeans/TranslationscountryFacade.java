/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Client;
import entityBeans.Country;
import entityBeans.Translationscountry;
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
public class TranslationscountryFacade extends AbstractFacade<Translationscountry> implements TranslationscountryFacadeLocal {
    @PersistenceContext(unitName = "WebsiteApplication-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TranslationscountryFacade() {
        super(Translationscountry.class);
    }
    
    @Override
    public List<Translationscountry> findCountryTranslationByLanguage(String language) {
        Query query = em.createNamedQuery("Translationscountry.findCountryTranslationByLanguage");
        query.setParameter("lang", language);
           
        return query.getResultList();
    }
    
    @Override
    public Translationscountry findCountryNameTranslated (String lang, String idCountry) 
    {
        Query query = em.createNamedQuery("Translationscountry.findCountryNameTranslated");
        query.setParameter("lang", lang);
        query.setParameter("id", idCountry);
        
        return (Translationscountry)query.getSingleResult();
    }
}
