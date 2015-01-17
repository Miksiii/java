/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.sessionBeans;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import rs.fit.interceptors.WSMethodsInterceptor;

/**
 *
 * @author miksi
 */
@Stateless
@Interceptors(WSMethodsInterceptor.class)
public class KrugSB implements KrugSBLocal {
    
    private double PI = 3.14;
    
    /**
     * Metoda za izracunavanje povrsine kruga
     * @param r
     * @return 
     */
    @Override
    public double getPovrsina(int r) {
        return PI*(r*r);
    }
    
    /**
     * Metoda za izracunavanje obima kruga
     * @param r
     * @return 
     */
    @Override
    public double getObim(int r) {
        return 2*PI*r;
    }

}
