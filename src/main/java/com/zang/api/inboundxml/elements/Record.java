
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
 *       &lt;attribute name="action" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="method" type="{}http_methods" />
 *       &lt;attribute name="timeout" type="{}positive_integer" />
 *       &lt;attribute name="finishOnKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="maxLength" type="{}positive_integer" />
 *       &lt;attribute name="transcribe" type="{}booleans" />
 *       &lt;attribute name="transcribeCallback" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="transcribeQuality" type="{}transcription_quality" />
 *       &lt;attribute name="sliceStart" type="{}positive_integer" />
 *       &lt;attribute name="sliceDuration" type="{}positive_integer" />
 *       &lt;attribute name="playBeep" type="{}booleans" />
 *       &lt;attribute name="bothLegs" type="{}booleans" />
 *       &lt;attribute name="fileFormat" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="direction" type="{}zangDirection" />
 *       &lt;attribute name="background" type="{}booleans" />
 *       &lt;attribute name="sampleRate" type="{}sample_rate" />
 *       &lt;attribute name="trimSilence" type="{}booleans" />
 *       &lt;attribute name="lifetime" type="{}positive_integer" />
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
@XmlRootElement(name = "Record")
public class Record {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "action")
    @XmlSchemaType(name = "anyURI")
    protected String action;
    @XmlAttribute(name = "method")
    protected String method;
    @XmlAttribute(name = "timeout")
    protected BigInteger timeout;
    @XmlAttribute(name = "finishOnKey")
    protected String finishOnKey;
    @XmlAttribute(name = "maxLength")
    protected BigInteger maxLength;
    @XmlAttribute(name = "transcribe")
    protected String transcribe;
    @XmlAttribute(name = "transcribeCallback")
    @XmlSchemaType(name = "anyURI")
    protected String transcribeCallback;
    @XmlAttribute(name = "transcribeQuality")
    protected String transcribeQuality;
    @XmlAttribute(name = "sliceStart")
    protected BigInteger sliceStart;
    @XmlAttribute(name = "sliceDuration")
    protected BigInteger sliceDuration;
    @XmlAttribute(name = "playBeep")
    protected String playBeep;
    @XmlAttribute(name = "bothLegs")
    protected String bothLegs;
    @XmlAttribute(name = "fileFormat")
    protected String fileFormat;
    @XmlAttribute(name = "direction")
    protected String direction;
    @XmlAttribute(name = "background")
    protected String background;
    @XmlAttribute(name = "sampleRate")
    protected BigInteger sampleRate;
    @XmlAttribute(name = "trimSilence")
    protected String trimSilence;
    @XmlAttribute(name = "lifetime")
    protected BigInteger lifetime;

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
     * Gets the value of the maxLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxLength(BigInteger value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the transcribe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranscribe() {
        return transcribe;
    }

    /**
     * Sets the value of the transcribe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranscribe(String value) {
        this.transcribe = value;
    }

    /**
     * Gets the value of the transcribeCallback property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranscribeCallback() {
        return transcribeCallback;
    }

    /**
     * Sets the value of the transcribeCallback property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranscribeCallback(String value) {
        this.transcribeCallback = value;
    }

    /**
     * Gets the value of the transcribeQuality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranscribeQuality() {
        return transcribeQuality;
    }

    /**
     * Sets the value of the transcribeQuality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranscribeQuality(String value) {
        this.transcribeQuality = value;
    }

    /**
     * Gets the value of the sliceStart property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSliceStart() {
        return sliceStart;
    }

    /**
     * Sets the value of the sliceStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSliceStart(BigInteger value) {
        this.sliceStart = value;
    }

    /**
     * Gets the value of the sliceDuration property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSliceDuration() {
        return sliceDuration;
    }

    /**
     * Sets the value of the sliceDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSliceDuration(BigInteger value) {
        this.sliceDuration = value;
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
     * Gets the value of the bothLegs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBothLegs() {
        return bothLegs;
    }

    /**
     * Sets the value of the bothLegs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBothLegs(String value) {
        this.bothLegs = value;
    }

    /**
     * Gets the value of the fileFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileFormat() {
        return fileFormat;
    }

    /**
     * Sets the value of the fileFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileFormat(String value) {
        this.fileFormat = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

    /**
     * Gets the value of the background property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackground() {
        return background;
    }

    /**
     * Sets the value of the background property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackground(String value) {
        this.background = value;
    }

    /**
     * Gets the value of the sampleRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSampleRate() {
        return sampleRate;
    }

    /**
     * Sets the value of the sampleRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSampleRate(BigInteger value) {
        this.sampleRate = value;
    }

    /**
     * Gets the value of the trimSilence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrimSilence() {
        return trimSilence;
    }

    /**
     * Sets the value of the trimSilence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrimSilence(String value) {
        this.trimSilence = value;
    }

    /**
     * Gets the value of the lifetime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLifetime() {
        return lifetime;
    }

    /**
     * Sets the value of the lifetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLifetime(BigInteger value) {
        this.lifetime = value;
    }

}
