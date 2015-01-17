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
public class PravougaonikSB implements PravougaonikSBLocal {

    /**
     * Metoda koja izracunava povrsinu pravougaonika
     * @param a
     * @param b
     * @return 
     */
    @Override
    public int getPovrsina(int a, int b) {
        return a*b;
    }

    /**
     * Metoda koja izracunava obim pravougaonika
     * @param a
     * @param b
     * @return 
     */
    @Override
    public int getObim(int a, int b) {
        return 2*(a+b);
    }

}
