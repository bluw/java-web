/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Translationscategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface TranslationscategoryFacadeLocal {

    void create(Translationscategory translationscategory);

    void edit(Translationscategory translationscategory);

    void remove(Translationscategory translationscategory);

    Translationscategory find(Object id);

    List<Translationscategory> findAll();

    List<Translationscategory> findRange(int[] range);

    int count();

    List<Translationscategory> findCategoryTranslationByLanguage(String language);
    
}
