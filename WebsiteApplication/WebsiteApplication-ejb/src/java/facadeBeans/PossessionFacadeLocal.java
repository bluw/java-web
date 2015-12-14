/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeBeans;

import entityBeans.Possession;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface PossessionFacadeLocal {

    void create(Possession possession);

    void edit(Possession possession);

    void remove(Possession possession);

    Possession find(Object id);

    List<Possession> findAll();

    List<Possession> findRange(int[] range);

    int count();
    
}
