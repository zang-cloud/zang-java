
package com.zang.api.inboundxml.elements;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
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
 *       &lt;attribute name="loop" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="voice" type="{}say_voice" />
 *       &lt;attribute name="language" type="{}tts_languages" />
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
@XmlRootElement(name = "Say")
public class Say {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "loop")
    protected BigInteger loop;
    @XmlAttribute(name = "voice")
    protected SayVoice voice;
    @XmlAttribute(name = "language")
    protected TtsLanguages language;

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
     * Gets the value of the loop property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLoop() {
        return loop;
    }

    /**
     * Sets the value of the loop property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLoop(BigInteger value) {
        this.loop = value;
    }

    /**
     * Gets the value of the voice property.
     * 
     * @return
     *     possible object is
     *     {@link SayVoice }
     *     
     */
    public SayVoice getVoice() {
        return voice;
    }

    /**
     * Sets the value of the voice property.
     * 
     * @param value
     *     allowed object is
     *     {@link SayVoice }
     *     
     */
    public void setVoice(SayVoice value) {
        this.voice = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link TtsLanguages }
     *     
     */
    public TtsLanguages getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link TtsLanguages }
     *     
     */
    public void setLanguage(TtsLanguages value) {
        this.language = value;
    }

}
