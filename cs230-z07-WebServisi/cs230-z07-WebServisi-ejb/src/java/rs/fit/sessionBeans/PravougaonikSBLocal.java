/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.sessionBeans;

import javax.ejb.Local;

/**
 *
 * @author miksi
 */
@Local
public interface PravougaonikSBLocal {
    int getPovrsina(int a, int b);
    int getObim(int a, int b);    
}
