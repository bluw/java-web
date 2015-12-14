/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Country;
import entityBeans.Translationscountry;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface TranslationscountryFacadeLocal {

    void create(Translationscountry translationscountry);

    void edit(Translationscountry translationscountry);

    void remove(Translationscountry translationscountry);

    Translationscountry find(Object id);

    List<Translationscountry> findAll();

    List<Translationscountry> findRange(int[] range);

    int count();
    
    List<Translationscountry> findCountryTranslationByLanguage(String language);
    
    Translationscountry findCountryNameTranslated (String lang, String idCountry);
}
