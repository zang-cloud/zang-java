
package com.zang.api.inboundxml.elements;

import java.math.BigInteger;
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
 *         &lt;element ref="{}PlayLastRecording" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Pause" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="action" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="method" type="{}http_methods" />
 *       &lt;attribute name="timeout" type="{}positive_integer" />
 *       &lt;attribute name="playBeep" type="{}booleans" />
 *       &lt;attribute name="grammar" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
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
@XmlRootElement(name = "GetSpeech")
public class GetSpeech {

    @XmlElementRefs({
        @XmlElementRef(name = "Pause", type = Pause.class, required = false),
        @XmlElementRef(name = "Say", type = Say.class, required = false),
        @XmlElementRef(name = "Play", type = Play.class, required = false),
        @XmlElementRef(name = "PlayLastRecording", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Object> content;
    @XmlAttribute(name = "action")
    @XmlSchemaType(name = "anyURI")
    protected String action;
    @XmlAttribute(name = "method")
    protected String method;
    @XmlAttribute(name = "timeout")
    protected BigInteger timeout;
    @XmlAttribute(name = "playBeep")
    protected String playBeep;
    @XmlAttribute(name = "grammar", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String grammar;

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
     * {@link Pause }
     * {@link Say }
     * {@link String }
     * {@link Play }
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
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
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Gets the value of the timeout property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimeout() {
        return timeout;
    }

    /**
     * Sets the value of the timeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimeout(BigInteger value) {
        this.timeout = value;
    }

    /**
     * Gets the value of the playBeep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlayBeep() {
        return playBeep;
    }

    /**
     * Sets the value of the playBeep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlayBeep(String value) {
        this.playBeep = value;
    }

    /**
     * Gets the value of the grammar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrammar() {
        return grammar;
    }

    /**
     * Sets the value of the grammar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrammar(String value) {
        this.grammar = value;
    }

}
