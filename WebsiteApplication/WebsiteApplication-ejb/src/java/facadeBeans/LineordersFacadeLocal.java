/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Lineorders;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface LineordersFacadeLocal {

    void create(Lineorders lineorders);

    void edit(Lineorders lineorders);

    void remove(Lineorders lineorders);

    Lineorders find(Object id);

    List<Lineorders> findAll();

    List<Lineorders> findRange(int[] range);

    int count();
    
    void addLineOrders(Lineorders line) throws Exception;
    
}
