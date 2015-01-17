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
public class KvadratSB implements KvadratSBLocal {
    
    /**
     * Metoda za izracunavanje povrsine kvadrata
     * @param a
     * @return 
     */
    @Override
    public int getPovrsina(int a) {
        return a*a;
    }

    /**
     * Metoda za izracunavanje obima kvadrata
     * @param a
     * @return 
     */
    @Override
    public int getObim(int a) {
        return 4*a;
    }

}
