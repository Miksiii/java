
package rs.fit.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Geometrija", targetNamespace = "http://webservices.fit.rs/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Geometrija {


    /**
     * 
     * @param r
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getKrugObim", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetKrugObim")
    @ResponseWrapper(localName = "getKrugObimResponse", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetKrugObimResponse")
    @Action(input = "http://webservices.fit.rs/Geometrija/getKrugObimRequest", output = "http://webservices.fit.rs/Geometrija/getKrugObimResponse")
    public double getKrugObim(
        @WebParam(name = "r", targetNamespace = "")
        int r);

    /**
     * 
     * @param b
     * @param a
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPravouganikPovrsina", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetPravouganikPovrsina")
    @ResponseWrapper(localName = "getPravouganikPovrsinaResponse", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetPravouganikPovrsinaResponse")
    @Action(input = "http://webservices.fit.rs/Geometrija/getPravouganikPovrsinaRequest", output = "http://webservices.fit.rs/Geometrija/getPravouganikPovrsinaResponse")
    public int getPravouganikPovrsina(
        @WebParam(name = "a", targetNamespace = "")
        int a,
        @WebParam(name = "b", targetNamespace = "")
        int b);

    /**
     * 
     * @param a
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getKvadratPovrsina", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetKvadratPovrsina")
    @ResponseWrapper(localName = "getKvadratPovrsinaResponse", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetKvadratPovrsinaResponse")
    @Action(input = "http://webservices.fit.rs/Geometrija/getKvadratPovrsinaRequest", output = "http://webservices.fit.rs/Geometrija/getKvadratPovrsinaResponse")
    public int getKvadratPovrsina(
        @WebParam(name = "a", targetNamespace = "")
        int a);

    /**
     * 
     * @param a
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getKvadratObim", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetKvadratObim")
    @ResponseWrapper(localName = "getKvadratObimResponse", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetKvadratObimResponse")
    @Action(input = "http://webservices.fit.rs/Geometrija/getKvadratObimRequest", output = "http://webservices.fit.rs/Geometrija/getKvadratObimResponse")
    public int getKvadratObim(
        @WebParam(name = "a", targetNamespace = "")
        int a);

    /**
     * 
     * @param b
     * @param a
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPravougaonikObim", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetPravougaonikObim")
    @ResponseWrapper(localName = "getPravougaonikObimResponse", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetPravougaonikObimResponse")
    @Action(input = "http://webservices.fit.rs/Geometrija/getPravougaonikObimRequest", output = "http://webservices.fit.rs/Geometrija/getPravougaonikObimResponse")
    public int getPravougaonikObim(
        @WebParam(name = "a", targetNamespace = "")
        int a,
        @WebParam(name = "b", targetNamespace = "")
        int b);

    /**
     * 
     * @param r
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getKrugPovrsina", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetKrugPovrsina")
    @ResponseWrapper(localName = "getKrugPovrsinaResponse", targetNamespace = "http://webservices.fit.rs/", className = "rs.fit.webservices.GetKrugPovrsinaResponse")
    @Action(input = "http://webservices.fit.rs/Geometrija/getKrugPovrsinaRequest", output = "http://webservices.fit.rs/Geometrija/getKrugPovrsinaResponse")
    public double getKrugPovrsina(
        @WebParam(name = "r", targetNamespace = "")
        int r);

}
