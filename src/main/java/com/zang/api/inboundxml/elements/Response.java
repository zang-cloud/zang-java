
package com.zang.api.inboundxml.elements;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}Say" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Play" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Answer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}PlayLastRecording" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Gather" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Record" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Dial" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Hangup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Redirect" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Ping" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Reject" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Pause" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Sms" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}GetSpeech" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="statusCallback" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="statusMethod" type="{}http_methods" />
 *       &lt;attribute name="heartbeatCallback" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="heartbeatMethod" type="{}http_methods" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "Response")
public class Response {

    @XmlElementRefs({
        @XmlElementRef(name = "Answer", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Record", type = Record.class, required = false),
        @XmlElementRef(name = "Pause", type = Pause.class, required = false),
        @XmlElementRef(name = "Redirect", type = Redirect.class, required = false),
        @XmlElementRef(name = "Ping", type = Ping.class, required = false),
        @XmlElementRef(name = "Sms", type = Sms.class, required = false),
        @XmlElementRef(name = "GetSpeech", type = GetSpeech.class, required = false),
        @XmlElementRef(name = "PlayLastRecording", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Reject", type = Reject.class, required = false),
        @XmlElementRef(name = "Dial", type = Dial.class, required = false),
        @XmlElementRef(name = "Hangup", type = Hangup.class, required = false),
        @XmlElementRef(name = "Say", type = Say.class, required = false),
        @XmlElementRef(name = "Play", type = Play.class, required = false),
        @XmlElementRef(name = "Gather", type = Gather.class, required = false)
    })
    @XmlMixed
    protected List<Object> content;
    @XmlAttribute(name = "statusCallback")
    @XmlSchemaType(name = "anyURI")
    protected String statusCallback;
    @XmlAttribute(name = "statusMethod")
    protected String statusMethod;
    @XmlAttribute(name = "heartbeatCallback")
    @XmlSchemaType(name = "anyURI")
    protected String heartbeatCallback;
    @XmlAttribute(name = "heartbeatMethod")
    protected String heartbeatMethod;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link Record }
     * {@link Pause }
     * {@link String }
     * {@link Redirect }
     * {@link Ping }
     * {@link Sms }
     * {@link GetSpeech }
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link Reject }
     * {@link Dial }
     * {@link Hangup }
     * {@link Say }
     * {@link Play }
     * {@link Gather }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

    /**
     * Gets the value of the statusCallback property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCallback() {
        return statusCallback;
    }

    /**
     * Sets the value of the statusCallback property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCallback(String value) {
        this.statusCallback = value;
    }

    /**
     * Gets the value of the statusMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusMethod() {
        return statusMethod;
    }

    /**
     * Sets the value of the statusMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusMethod(String value) {
        this.statusMethod = value;
    }

    /**
     * Gets the value of the heartbeatCallback property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeartbeatCallback() {
        return heartbeatCallback;
    }

    /**
     * Sets the value of the heartbeatCallback property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeartbeatCallback(String value) {
        this.heartbeatCallback = value;
    }

    /**
     * Gets the value of the heartbeatMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeartbeatMethod() {
        return heartbeatMethod;
    }

    /**
     * Sets the value of the heartbeatMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeartbeatMethod(String value) {
        this.heartbeatMethod = value;
    }

}
