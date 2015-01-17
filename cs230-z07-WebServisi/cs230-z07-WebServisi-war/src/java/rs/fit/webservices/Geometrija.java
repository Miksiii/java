/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.webservices;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import rs.fit.sessionBeans.KrugSBLocal;
import rs.fit.sessionBeans.KvadratSBLocal;
import rs.fit.sessionBeans.PravougaonikSBLocal;

/**
 *
 * @author miksi
 */
@WebService(serviceName = "Geometrija")
public class Geometrija {
    @EJB
    private KrugSBLocal krugSB;
    @EJB
    private PravougaonikSBLocal pravougaonikSB;
    @EJB
    private KvadratSBLocal kvadratSB;

    /**
     * Web service operation
     * Metoda koja izracunava povrsinu kvadrata
     * @param a
     * @return povrsina
     */
    @WebMethod(operationName = "getKvadratPovrsina")
    public int getKvadratPovrsina(@WebParam(name = "a") int a) {
        return kvadratSB.getPovrsina(a);
    }
    
    /**
     * Web service operation
     * Metoda koja izracunava obim kvadrata
     * @param a
     * @return obim
     */
    @WebMethod(operationName = "getKvadratObim")
    public int getKvadratObim(@WebParam(name = "a") int a) {
        return kvadratSB.getObim(a);
    }
 
    /**
     * Web service operation
     * Metoda koja izracunava povrsinu pravougaonika
     * @param a
     * @param b
     * @return povrsina
     */
    @WebMethod(operationName = "getPravouganikPovrsina")
    public int getPravouganikPovrsina(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return pravougaonikSB.getPovrsina(a, b);
    }
    
    /**
     * Web service operation
     * Metoda koja izracunava obim pravougaonika
     * @param a
     * @param b
     * @return obim
     */
    @WebMethod(operationName = "getPravougaonikObim")
    public int getPravougaonikObim(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return pravougaonikSB.getObim(a, b);
    }

    /**
     * Web service operation
     * Metoda koja izracunava povrsinu kvadrata
     * @param r
     * @return povrsina
     */
    @WebMethod(operationName = "getKrugPovrsina")
    public double getKrugPovrsina(@WebParam(name = "r") int r) {
        return krugSB.getPovrsina(r);
    }
    
    /**
     * Web service operation
     * Metoda koja izracunava obim kvadrata
     * @param r
     * @return obim
     */
    @WebMethod(operationName = "getKrugObim")
    public double getKrugObim(@WebParam(name = "r") int r) {
        return krugSB.getObim(r);
    }
    
    
    
}
