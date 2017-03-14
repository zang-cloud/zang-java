
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
 *       &lt;attribute name="finishOnKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numDigits" type="{http://www.w3.org/2001/XMLSchema}integer" />
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
@XmlRootElement(name = "Gather")
public class Gather {

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
    @XmlAttribute(name = "finishOnKey")
    protected String finishOnKey;
    @XmlAttribute(name = "numDigits")
    protected BigInteger numDigits;

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
     * Gets the value of the finishOnKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinishOnKey() {
        return finishOnKey;
    }

    /**
     * Sets the value of the finishOnKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinishOnKey(String value) {
        this.finishOnKey = value;
    }

    /**
     * Gets the value of the numDigits property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumDigits() {
        return numDigits;
    }

    /**
     * Sets the value of the numDigits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumDigits(BigInteger value) {
        this.numDigits = value;
    }

}
