/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;
import rs.fit.webservices.Geometrija_Service;

/**
 *
 * @author miksi
 */
@ManagedBean
@RequestScoped
public class ClientObj {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/cs230-z07-WebServisi-war/Geometrija.wsdl")
    private Geometrija_Service service;
    private int a;
    private int b;
    private int r;
    private int rezultat;

    /**
     * Geter za prvu stranicu geometrijske figure
     * @return 
     */
    public int getA() {
        return a;
    }

    /**
     * Seter za prvi stranicu geometrijske figure
     * @param a
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * Geter za drugu stranicu geometrijske figure
     * @return 
     */
    public int getB() {
        return b;
    }
    
    /**
     * Seter za drugu stranicu geometrijske figure
     * @param b
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * Geter za poluprecnik gemetrijske figure
     * @return 
     */    
    public int getR() {
        return r;
    }
    
    /**
     * Seter za poluprecnik gemetrijske figure 
     * @param r
     */    
    public void setR(int r) {
        this.r = r;
    }

    /**
     * Geter za rezultat
     * @return 
     */
    public int getRezultat() {
        return rezultat;
    }

    /**
     * Seter za rezultat
     * @param rezultat 
     */
    public void setRezultat(int rezultat) {
        this.rezultat = rezultat;
    }
    
    /**
     * Konstruktor
     */
    public ClientObj() {
    }
    
    /**
     * Metoda koja poziva metodu veb servisa za izracunavanje obima pravougaonika
     */
    public void pravougaonikObim() {
        rezultat = getPravougaonikObim(a, b);
    }
    
    /**
     * Metoda koja poziva metodu veb servisa za izracunavanje povrsine pravougaonika
     */
    public void pravougaonikPovrsina() {
        rezultat = getPravouganikPovrsina(a, b);
    }
    
    /**
     * Metoda koja poziva metodu veb servisa za izracunavanje obima kvadrata
     */
    public void kvadratObim() {
        rezultat = getKvadratObim(a);
    }
    
    /**
     * Metoda koja poziva metodu veb servisa za izracunavanje povrsine kvadrata
     */
    public void kvadratPovrsina() {
        rezultat = getKvadratPovrsina(a);
    }
    
    /**
     * Metoda koja poziva metodu veb servisa za izracunavanje obima kruga
     */
    public void krugObim() {
        rezultat = (int) getKrugObim(r);
    }
    
    /**
     * Metoda koja poziva metodu veb servisa za izracunavanje povrsine kruga
     */
    public void krugPovrsina() {
        rezultat = (int) getKrugPovrsina(r);
    }

    /**
     * WEB SERVICS METHODS..
     */
    
    private double getKrugObim(int r) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        rs.fit.webservices.Geometrija port = service.getGeometrijaPort();
        return port.getKrugObim(r);
    }

    private double getKrugPovrsina(int r) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        rs.fit.webservices.Geometrija port = service.getGeometrijaPort();
        return port.getKrugPovrsina(r);
    }

    private int getKvadratObim(int a) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        rs.fit.webservices.Geometrija port = service.getGeometrijaPort();
        return port.getKvadratObim(a);
    }

    private int getKvadratPovrsina(int a) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        rs.fit.webservices.Geometrija port = service.getGeometrijaPort();
        return port.getKvadratPovrsina(a);
    }

    private int getPravouganikPovrsina(int a, int b) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        rs.fit.webservices.Geometrija port = service.getGeometrijaPort();
        return port.getPravouganikPovrsina(a, b);
    }

    private int getPravougaonikObim(int a, int b) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        rs.fit.webservices.Geometrija port = service.getGeometrijaPort();
        return port.getPravougaonikObim(a, b);
    }
    
    
    
}
