
package com.udea.skadysystem.wssoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.udea.skadysystem.wssoap package. 
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

    private final static QName _AgregarEmpleado_QNAME = new QName("http://ws.paletas_service.udea.com/", "agregarEmpleado");
    private final static QName _AgregarEmpleadoResponse_QNAME = new QName("http://ws.paletas_service.udea.com/", "agregarEmpleadoResponse");
    private final static QName _AgregarPaleta_QNAME = new QName("http://ws.paletas_service.udea.com/", "agregarPaleta");
    private final static QName _AgregarPaletaResponse_QNAME = new QName("http://ws.paletas_service.udea.com/", "agregarPaletaResponse");
    private final static QName _Hello_QNAME = new QName("http://ws.paletas_service.udea.com/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://ws.paletas_service.udea.com/", "helloResponse");
    private final static QName _VerPaletas_QNAME = new QName("http://ws.paletas_service.udea.com/", "verPaletas");
    private final static QName _VerPaletasResponse_QNAME = new QName("http://ws.paletas_service.udea.com/", "verPaletasResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.udea.skadysystem.wssoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AgregarEmpleado }
     * 
     */
    public AgregarEmpleado createAgregarEmpleado() {
        return new AgregarEmpleado();
    }

    /**
     * Create an instance of {@link AgregarEmpleadoResponse }
     * 
     */
    public AgregarEmpleadoResponse createAgregarEmpleadoResponse() {
        return new AgregarEmpleadoResponse();
    }

    /**
     * Create an instance of {@link AgregarPaleta }
     * 
     */
    public AgregarPaleta createAgregarPaleta() {
        return new AgregarPaleta();
    }

    /**
     * Create an instance of {@link AgregarPaletaResponse }
     * 
     */
    public AgregarPaletaResponse createAgregarPaletaResponse() {
        return new AgregarPaletaResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link VerPaletas }
     * 
     */
    public VerPaletas createVerPaletas() {
        return new VerPaletas();
    }

    /**
     * Create an instance of {@link VerPaletasResponse }
     * 
     */
    public VerPaletasResponse createVerPaletasResponse() {
        return new VerPaletasResponse();
    }

    /**
     * Create an instance of {@link Paleta }
     * 
     */
    public Paleta createPaleta() {
        return new Paleta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.paletas_service.udea.com/", name = "agregarEmpleado")
    public JAXBElement<AgregarEmpleado> createAgregarEmpleado(AgregarEmpleado value) {
        return new JAXBElement<AgregarEmpleado>(_AgregarEmpleado_QNAME, AgregarEmpleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarEmpleadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.paletas_service.udea.com/", name = "agregarEmpleadoResponse")
    public JAXBElement<AgregarEmpleadoResponse> createAgregarEmpleadoResponse(AgregarEmpleadoResponse value) {
        return new JAXBElement<AgregarEmpleadoResponse>(_AgregarEmpleadoResponse_QNAME, AgregarEmpleadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarPaleta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.paletas_service.udea.com/", name = "agregarPaleta")
    public JAXBElement<AgregarPaleta> createAgregarPaleta(AgregarPaleta value) {
        return new JAXBElement<AgregarPaleta>(_AgregarPaleta_QNAME, AgregarPaleta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarPaletaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.paletas_service.udea.com/", name = "agregarPaletaResponse")
    public JAXBElement<AgregarPaletaResponse> createAgregarPaletaResponse(AgregarPaletaResponse value) {
        return new JAXBElement<AgregarPaletaResponse>(_AgregarPaletaResponse_QNAME, AgregarPaletaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.paletas_service.udea.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.paletas_service.udea.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerPaletas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.paletas_service.udea.com/", name = "verPaletas")
    public JAXBElement<VerPaletas> createVerPaletas(VerPaletas value) {
        return new JAXBElement<VerPaletas>(_VerPaletas_QNAME, VerPaletas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerPaletasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.paletas_service.udea.com/", name = "verPaletasResponse")
    public JAXBElement<VerPaletasResponse> createVerPaletasResponse(VerPaletasResponse value) {
        return new JAXBElement<VerPaletasResponse>(_VerPaletasResponse_QNAME, VerPaletasResponse.class, null, value);
    }

}
