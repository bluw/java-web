/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Languages;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface LanguagesFacadeLocal {

    void create(Languages languages);

    void edit(Languages languages);

    void remove(Languages languages);

    Languages find(Object id);

    List<Languages> findAll();

    List<Languages> findRange(int[] range);

    int count();
    
}
