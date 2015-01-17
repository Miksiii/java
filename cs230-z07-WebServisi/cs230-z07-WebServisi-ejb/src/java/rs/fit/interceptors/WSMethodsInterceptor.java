/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.interceptors;

import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author miksi
 */
public class WSMethodsInterceptor {
    
    /**
     * Intercept metoda poziva se prilikom pozivanja svake od metoda 
     * veb servisa za koje je ona definisana. Ona najpre prikuplja parametre
     * I proverava da li je neki od parametara manji ili jednak nuli, ukoliko 
     * jeste setuje im vrednosti na nulu cime onemogucava metodu da izvrsi 
     * deo funkcionalnosti.
     * @param context
     * @return
     * @throws Exception 
     */
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        System.out.println("*** Intercept metod pozvan.. ***");
        Object[] params = context.getParameters();

        for(int i = 0; i < params.length; i++) {
            if((int) params[i] <= 0) {
                params[i] = 0;
            }
        }
        
        Object result = context.proceed();
        return result;
    }
 
}
