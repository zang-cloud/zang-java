
package com.zang.api.inboundxml.elements;

import java.math.BigInteger;
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
 *       &lt;attribute name="muted" type="{}booleans" />
 *       &lt;attribute name="beep" type="{}booleans" />
 *       &lt;attribute name="startConferenceOnEnter" type="{}booleans" />
 *       &lt;attribute name="endConferenceOnExit" type="{}booleans" />
 *       &lt;attribute name="maxParticipants" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="timeLimit" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="waitUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="waitMethod" type="{}http_methods" />
 *       &lt;attribute name="hangupOnStar" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="callbackUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="callbackMethod" type="{}http_methods" />
 *       &lt;attribute name="method" type="{}http_methods" />
 *       &lt;attribute name="waitSound" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="waitSoundMethod" type="{}http_methods" />
 *       &lt;attribute name="digitsMatch" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="stayAlone" type="{}booleans" />
 *       &lt;attribute name="record" type="{}booleans" />
 *       &lt;attribute name="recordFileFormat" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="recordCallbackUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="recordCallbackMethod" type="{}http_methods" />
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
@XmlRootElement(name = "Conference")
public class Conference {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "muted")
    protected String muted;
    @XmlAttribute(name = "beep")
    protected String beep;
    @XmlAttribute(name = "startConferenceOnEnter")
    protected String startConferenceOnEnter;
    @XmlAttribute(name = "endConferenceOnExit")
    protected String endConferenceOnExit;
    @XmlAttribute(name = "maxParticipants")
    protected BigInteger maxParticipants;
    @XmlAttribute(name = "timeLimit")
    protected BigInteger timeLimit;
    @XmlAttribute(name = "waitUrl")
    @XmlSchemaType(name = "anyURI")
    protected String waitUrl;
    @XmlAttribute(name = "waitMethod")
    protected String waitMethod;
    @XmlAttribute(name = "hangupOnStar")
    protected String hangupOnStar;
    @XmlAttribute(name = "callbackUrl")
    @XmlSchemaType(name = "anyURI")
    protected String callbackUrl;
    @XmlAttribute(name = "callbackMethod")
    protected String callbackMethod;
    @XmlAttribute(name = "method")
    protected String method;
    @XmlAttribute(name = "waitSound")
    @XmlSchemaType(name = "anyURI")
    protected String waitSound;
    @XmlAttribute(name = "waitSoundMethod")
    protected String waitSoundMethod;
    @XmlAttribute(name = "digitsMatch")
    protected String digitsMatch;
    @XmlAttribute(name = "stayAlone")
    protected String stayAlone;
    @XmlAttribute(name = "record")
    protected String record;
    @XmlAttribute(name = "recordFileFormat")
    protected String recordFileFormat;
    @XmlAttribute(name = "recordCallbackUrl")
    @XmlSchemaType(name = "anyURI")
    protected String recordCallbackUrl;
    @XmlAttribute(name = "recordCallbackMethod")
    protected String recordCallbackMethod;

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
     * Gets the value of the muted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMuted() {
        return muted;
    }

    /**
     * Sets the value of the muted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMuted(String value) {
        this.muted = value;
    }

    /**
     * Gets the value of the beep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeep() {
        return beep;
    }

    /**
     * Sets the value of the beep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeep(String value) {
        this.beep = value;
    }

    /**
     * Gets the value of the startConferenceOnEnter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartConferenceOnEnter() {
        return startConferenceOnEnter;
    }

    /**
     * Sets the value of the startConferenceOnEnter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartConferenceOnEnter(String value) {
        this.startConferenceOnEnter = value;
    }

    /**
     * Gets the value of the endConferenceOnExit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndConferenceOnExit() {
        return endConferenceOnExit;
    }

    /**
     * Sets the value of the endConferenceOnExit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndConferenceOnExit(String value) {
        this.endConferenceOnExit = value;
    }

    /**
     * Gets the value of the maxParticipants property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxParticipants() {
        return maxParticipants;
    }

    /**
     * Sets the value of the maxParticipants property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxParticipants(BigInteger value) {
        this.maxParticipants = value;
    }

    /**
     * Gets the value of the timeLimit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimeLimit() {
        return timeLimit;
    }

    /**
     * Sets the value of the timeLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimeLimit(BigInteger value) {
        this.timeLimit = value;
    }

    /**
     * Gets the value of the waitUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitUrl() {
        return waitUrl;
    }

    /**
     * Sets the value of the waitUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitUrl(String value) {
        this.waitUrl = value;
    }

    /**
     * Gets the value of the waitMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitMethod() {
        return waitMethod;
    }

    /**
     * Sets the value of the waitMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitMethod(String value) {
        this.waitMethod = value;
    }

    /**
     * Gets the value of the hangupOnStar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHangupOnStar() {
        return hangupOnStar;
    }

    /**
     * Sets the value of the hangupOnStar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHangupOnStar(String value) {
        this.hangupOnStar = value;
    }

    /**
     * Gets the value of the callbackUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * Sets the value of the callbackUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallbackUrl(String value) {
        this.callbackUrl = value;
    }

    /**
     * Gets the value of the callbackMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallbackMethod() {
        return callbackMethod;
    }

    /**
     * Sets the value of the callbackMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallbackMethod(String value) {
        this.callbackMethod = value;
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
     * Gets the value of the waitSound property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitSound() {
        return waitSound;
    }

    /**
     * Sets the value of the waitSound property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitSound(String value) {
        this.waitSound = value;
    }

    /**
     * Gets the value of the waitSoundMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitSoundMethod() {
        return waitSoundMethod;
    }

    /**
     * Sets the value of the waitSoundMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitSoundMethod(String value) {
        this.waitSoundMethod = value;
    }

    /**
     * Gets the value of the digitsMatch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigitsMatch() {
        return digitsMatch;
    }

    /**
     * Sets the value of the digitsMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigitsMatch(String value) {
        this.digitsMatch = value;
    }

    /**
     * Gets the value of the stayAlone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStayAlone() {
        return stayAlone;
    }

    /**
     * Sets the value of the stayAlone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStayAlone(String value) {
        this.stayAlone = value;
    }

    /**
     * Gets the value of the record property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecord() {
        return record;
    }

    /**
     * Sets the value of the record property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecord(String value) {
        this.record = value;
    }

    /**
     * Gets the value of the recordFileFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordFileFormat() {
        return recordFileFormat;
    }

    /**
     * Sets the value of the recordFileFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordFileFormat(String value) {
        this.recordFileFormat = value;
    }

    /**
     * Gets the value of the recordCallbackUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordCallbackUrl() {
        return recordCallbackUrl;
    }

    /**
     * Sets the value of the recordCallbackUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordCallbackUrl(String value) {
        this.recordCallbackUrl = value;
    }

    /**
     * Gets the value of the recordCallbackMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordCallbackMethod() {
        return recordCallbackMethod;
    }

    /**
     * Sets the value of the recordCallbackMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordCallbackMethod(String value) {
        this.recordCallbackMethod = value;
    }

}
