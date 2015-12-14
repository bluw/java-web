/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Keyboard;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface KeyboardFacadeLocal {

    void create(Keyboard keyboard);

    void edit(Keyboard keyboard);

    void remove(Keyboard keyboard);

    Keyboard find(Object id);

    List<Keyboard> findAll();

    List<Keyboard> findRange(int[] range);

    int count();
    
    List<Keyboard> findByCategory(String labelCategory);
    
}
