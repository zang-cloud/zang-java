
package com.zang.api.inboundxml.elements;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.zang.api.inboundxml.elements package. 
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

    private final static QName _Answer_QNAME = new QName("", "Answer");
    private final static QName _PlayLastRecording_QNAME = new QName("", "PlayLastRecording");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zang.api.inboundxml.elements
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Pause }
     * 
     */
    public Pause createPause() {
        return new Pause();
    }

    /**
     * Create an instance of {@link Hangup }
     * 
     */
    public Hangup createHangup() {
        return new Hangup();
    }

    /**
     * Create an instance of {@link Say }
     * 
     */
    public Say createSay() {
        return new Say();
    }

    /**
     * Create an instance of {@link Redirect }
     * 
     */
    public Redirect createRedirect() {
        return new Redirect();
    }

    /**
     * Create an instance of {@link Conference }
     * 
     */
    public Conference createConference() {
        return new Conference();
    }

    /**
     * Create an instance of {@link Gather }
     * 
     */
    public Gather createGather() {
        return new Gather();
    }

    /**
     * Create an instance of {@link Play }
     * 
     */
    public Play createPlay() {
        return new Play();
    }

    /**
     * Create an instance of {@link Dial }
     * 
     */
    public Dial createDial() {
        return new Dial();
    }

    /**
     * Create an instance of {@link Number }
     * 
     */
    public Number createNumber() {
        return new Number();
    }

    /**
     * Create an instance of {@link Sip }
     * 
     */
    public Sip createSip() {
        return new Sip();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link Record }
     * 
     */
    public Record createRecord() {
        return new Record();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link Reject }
     * 
     */
    public Reject createReject() {
        return new Reject();
    }

    /**
     * Create an instance of {@link Sms }
     * 
     */
    public Sms createSms() {
        return new Sms();
    }

    /**
     * Create an instance of {@link GetSpeech }
     * 
     */
    public GetSpeech createGetSpeech() {
        return new GetSpeech();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Answer")
    public JAXBElement<Object> createAnswer(Object value) {
        return new JAXBElement<Object>(_Answer_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PlayLastRecording")
    public JAXBElement<Object> createPlayLastRecording(Object value) {
        return new JAXBElement<Object>(_PlayLastRecording_QNAME, Object.class, null, value);
    }

}
