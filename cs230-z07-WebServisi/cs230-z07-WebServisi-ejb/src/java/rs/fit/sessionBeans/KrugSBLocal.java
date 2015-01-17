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
public interface KrugSBLocal {   
    double getPovrsina(int r);
    double getObim(int r);
}
