
package rs.fit.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.fit.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetKrugPovrsina_QNAME = new QName("http://webservices.fit.rs/", "getKrugPovrsina");
    private final static QName _GetPravouganikPovrsina_QNAME = new QName("http://webservices.fit.rs/", "getPravouganikPovrsina");
    private final static QName _GetPravougaonikObim_QNAME = new QName("http://webservices.fit.rs/", "getPravougaonikObim");
    private final static QName _GetKvadratPovrsina_QNAME = new QName("http://webservices.fit.rs/", "getKvadratPovrsina");
    private final static QName _GetPravougaonikObimResponse_QNAME = new QName("http://webservices.fit.rs/", "getPravougaonikObimResponse");
    private final static QName _GetKrugPovrsinaResponse_QNAME = new QName("http://webservices.fit.rs/", "getKrugPovrsinaResponse");
    private final static QName _GetKrugObim_QNAME = new QName("http://webservices.fit.rs/", "getKrugObim");
    private final static QName _GetPravouganikPovrsinaResponse_QNAME = new QName("http://webservices.fit.rs/", "getPravouganikPovrsinaResponse");
    private final static QName _GetKvadratObimResponse_QNAME = new QName("http://webservices.fit.rs/", "getKvadratObimResponse");
    private final static QName _GetKrugObimResponse_QNAME = new QName("http://webservices.fit.rs/", "getKrugObimResponse");
    private final static QName _GetKvadratObim_QNAME = new QName("http://webservices.fit.rs/", "getKvadratObim");
    private final static QName _GetKvadratPovrsinaResponse_QNAME = new QName("http://webservices.fit.rs/", "getKvadratPovrsinaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.fit.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetKvadratPovrsina }
     * 
     */
    public GetKvadratPovrsina createGetKvadratPovrsina() {
        return new GetKvadratPovrsina();
    }

    /**
     * Create an instance of {@link GetPravougaonikObim }
     * 
     */
    public GetPravougaonikObim createGetPravougaonikObim() {
        return new GetPravougaonikObim();
    }

    /**
     * Create an instance of {@link GetPravouganikPovrsina }
     * 
     */
    public GetPravouganikPovrsina createGetPravouganikPovrsina() {
        return new GetPravouganikPovrsina();
    }

    /**
     * Create an instance of {@link GetKrugPovrsina }
     * 
     */
    public GetKrugPovrsina createGetKrugPovrsina() {
        return new GetKrugPovrsina();
    }

    /**
     * Create an instance of {@link GetKrugPovrsinaResponse }
     * 
     */
    public GetKrugPovrsinaResponse createGetKrugPovrsinaResponse() {
        return new GetKrugPovrsinaResponse();
    }

    /**
     * Create an instance of {@link GetPravougaonikObimResponse }
     * 
     */
    public GetPravougaonikObimResponse createGetPravougaonikObimResponse() {
        return new GetPravougaonikObimResponse();
    }

    /**
     * Create an instance of {@link GetKrugObim }
     * 
     */
    public GetKrugObim createGetKrugObim() {
        return new GetKrugObim();
    }

    /**
     * Create an instance of {@link GetKvadratPovrsinaResponse }
     * 
     */
    public GetKvadratPovrsinaResponse createGetKvadratPovrsinaResponse() {
        return new GetKvadratPovrsinaResponse();
    }

    /**
     * Create an instance of {@link GetKvadratObim }
     * 
     */
    public GetKvadratObim createGetKvadratObim() {
        return new GetKvadratObim();
    }

    /**
     * Create an instance of {@link GetKrugObimResponse }
     * 
     */
    public GetKrugObimResponse createGetKrugObimResponse() {
        return new GetKrugObimResponse();
    }

    /**
     * Create an instance of {@link GetKvadratObimResponse }
     * 
     */
    public GetKvadratObimResponse createGetKvadratObimResponse() {
        return new GetKvadratObimResponse();
    }

    /**
     * Create an instance of {@link GetPravouganikPovrsinaResponse }
     * 
     */
    public GetPravouganikPovrsinaResponse createGetPravouganikPovrsinaResponse() {
        return new GetPravouganikPovrsinaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKrugPovrsina }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getKrugPovrsina")
    public JAXBElement<GetKrugPovrsina> createGetKrugPovrsina(GetKrugPovrsina value) {
        return new JAXBElement<GetKrugPovrsina>(_GetKrugPovrsina_QNAME, GetKrugPovrsina.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPravouganikPovrsina }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getPravouganikPovrsina")
    public JAXBElement<GetPravouganikPovrsina> createGetPravouganikPovrsina(GetPravouganikPovrsina value) {
        return new JAXBElement<GetPravouganikPovrsina>(_GetPravouganikPovrsina_QNAME, GetPravouganikPovrsina.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPravougaonikObim }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getPravougaonikObim")
    public JAXBElement<GetPravougaonikObim> createGetPravougaonikObim(GetPravougaonikObim value) {
        return new JAXBElement<GetPravougaonikObim>(_GetPravougaonikObim_QNAME, GetPravougaonikObim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKvadratPovrsina }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getKvadratPovrsina")
    public JAXBElement<GetKvadratPovrsina> createGetKvadratPovrsina(GetKvadratPovrsina value) {
        return new JAXBElement<GetKvadratPovrsina>(_GetKvadratPovrsina_QNAME, GetKvadratPovrsina.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPravougaonikObimResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getPravougaonikObimResponse")
    public JAXBElement<GetPravougaonikObimResponse> createGetPravougaonikObimResponse(GetPravougaonikObimResponse value) {
        return new JAXBElement<GetPravougaonikObimResponse>(_GetPravougaonikObimResponse_QNAME, GetPravougaonikObimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKrugPovrsinaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getKrugPovrsinaResponse")
    public JAXBElement<GetKrugPovrsinaResponse> createGetKrugPovrsinaResponse(GetKrugPovrsinaResponse value) {
        return new JAXBElement<GetKrugPovrsinaResponse>(_GetKrugPovrsinaResponse_QNAME, GetKrugPovrsinaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKrugObim }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getKrugObim")
    public JAXBElement<GetKrugObim> createGetKrugObim(GetKrugObim value) {
        return new JAXBElement<GetKrugObim>(_GetKrugObim_QNAME, GetKrugObim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPravouganikPovrsinaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getPravouganikPovrsinaResponse")
    public JAXBElement<GetPravouganikPovrsinaResponse> createGetPravouganikPovrsinaResponse(GetPravouganikPovrsinaResponse value) {
        return new JAXBElement<GetPravouganikPovrsinaResponse>(_GetPravouganikPovrsinaResponse_QNAME, GetPravouganikPovrsinaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKvadratObimResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getKvadratObimResponse")
    public JAXBElement<GetKvadratObimResponse> createGetKvadratObimResponse(GetKvadratObimResponse value) {
        return new JAXBElement<GetKvadratObimResponse>(_GetKvadratObimResponse_QNAME, GetKvadratObimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKrugObimResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getKrugObimResponse")
    public JAXBElement<GetKrugObimResponse> createGetKrugObimResponse(GetKrugObimResponse value) {
        return new JAXBElement<GetKrugObimResponse>(_GetKrugObimResponse_QNAME, GetKrugObimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKvadratObim }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getKvadratObim")
    public JAXBElement<GetKvadratObim> createGetKvadratObim(GetKvadratObim value) {
        return new JAXBElement<GetKvadratObim>(_GetKvadratObim_QNAME, GetKvadratObim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKvadratPovrsinaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.fit.rs/", name = "getKvadratPovrsinaResponse")
    public JAXBElement<GetKvadratPovrsinaResponse> createGetKvadratPovrsinaResponse(GetKvadratPovrsinaResponse value) {
        return new JAXBElement<GetKvadratPovrsinaResponse>(_GetKvadratPovrsinaResponse_QNAME, GetKvadratPovrsinaResponse.class, null, value);
    }

}
