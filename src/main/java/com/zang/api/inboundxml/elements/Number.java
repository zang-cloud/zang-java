
package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="sendDigits" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="method" type="{}http_methods" />
 *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="sendOnPreanswer" type="{}booleans" />
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
@XmlRootElement(name = "Number")
public class Number {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "sendDigits")
    protected String sendDigits;
    @XmlAttribute(name = "method")
    protected String method;
    @XmlAttribute(name = "url")
    @XmlSchemaType(name = "anyURI")
    protected String url;
    @XmlAttribute(name = "sendOnPreanswer")
    protected String sendOnPreanswer;

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the sendDigits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendDigits() {
        return sendDigits;
    }

    /**
     * Sets the value of the sendDigits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendDigits(String value) {
        this.sendDigits = value;
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
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the sendOnPreanswer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendOnPreanswer() {
        return sendOnPreanswer;
    }

    /**
     * Sets the value of the sendOnPreanswer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendOnPreanswer(String value) {
        this.sendOnPreanswer = value;
    }

}
