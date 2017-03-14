
package com.zang.api.inboundxml.elements;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}Conference"/>
 *         &lt;element ref="{}Number"/>
 *         &lt;element ref="{}Sip"/>
 *         &lt;element ref="{}User"/>
 *       &lt;/choice>
 *       &lt;attribute name="action" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="method" type="{}http_methods" />
 *       &lt;attribute name="timeout" type="{}positive_integer" />
 *       &lt;attribute name="hangupOnStar" type="{}booleans" />
 *       &lt;attribute name="timeLimit" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="callerId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="hideCallerId" type="{}booleans" />
 *       &lt;attribute name="callerName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dialMusic" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="callbackUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="callbackMethod" type="{}http_methods" />
 *       &lt;attribute name="confirmSound" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="digitsMatch" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="straightToVm" type="{}boolean_or_positive_integer" />
 *       &lt;attribute name="heartbeatUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="heartbeatMethod" type="{}http_methods" />
 *       &lt;attribute name="forwardedFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="record" type="{}booleans" />
 *       &lt;attribute name="recordDirection" type="{}zangDirection" />
 *       &lt;attribute name="recordCallbackUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="recordLifetime" type="{}positive_integer" />
 *       &lt;attribute name="recordFormat" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ifMachine" type="{}if_machine" />
 *       &lt;attribute name="ifMachineUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="ifMachineMethod" type="{}http_methods" />
 *       &lt;attribute name="outboundAction" type="{}booleans" />
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
@XmlRootElement(name = "Dial")
public class Dial {

    @XmlElementRefs({
        @XmlElementRef(name = "User", type = User.class, required = false),
        @XmlElementRef(name = "Sip", type = Sip.class, required = false),
        @XmlElementRef(name = "Conference", type = Conference.class, required = false),
        @XmlElementRef(name = "Number", type = Number.class, required = false)
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
    @XmlAttribute(name = "hangupOnStar")
    protected String hangupOnStar;
    @XmlAttribute(name = "timeLimit")
    protected BigInteger timeLimit;
    @XmlAttribute(name = "callerId")
    protected String callerId;
    @XmlAttribute(name = "hideCallerId")
    protected String hideCallerId;
    @XmlAttribute(name = "callerName")
    protected String callerName;
    @XmlAttribute(name = "dialMusic")
    @XmlSchemaType(name = "anyURI")
    protected String dialMusic;
    @XmlAttribute(name = "callbackUrl")
    @XmlSchemaType(name = "anyURI")
    protected String callbackUrl;
    @XmlAttribute(name = "callbackMethod")
    protected String callbackMethod;
    @XmlAttribute(name = "confirmSound")
    protected String confirmSound;
    @XmlAttribute(name = "digitsMatch")
    protected String digitsMatch;
    @XmlAttribute(name = "straightToVm")
    protected String straightToVm;
    @XmlAttribute(name = "heartbeatUrl")
    @XmlSchemaType(name = "anyURI")
    protected String heartbeatUrl;
    @XmlAttribute(name = "heartbeatMethod")
    protected String heartbeatMethod;
    @XmlAttribute(name = "forwardedFrom")
    protected String forwardedFrom;
    @XmlAttribute(name = "record")
    protected String record;
    @XmlAttribute(name = "recordDirection")
    protected String recordDirection;
    @XmlAttribute(name = "recordCallbackUrl")
    @XmlSchemaType(name = "anyURI")
    protected String recordCallbackUrl;
    @XmlAttribute(name = "recordLifetime")
    protected BigInteger recordLifetime;
    @XmlAttribute(name = "recordFormat")
    protected String recordFormat;
    @XmlAttribute(name = "ifMachine")
    protected String ifMachine;
    @XmlAttribute(name = "ifMachineUrl")
    @XmlSchemaType(name = "anyURI")
    protected String ifMachineUrl;
    @XmlAttribute(name = "ifMachineMethod")
    protected String ifMachineMethod;
    @XmlAttribute(name = "outboundAction")
    protected String outboundAction;

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
     * {@link Sip }
     * {@link String }
     * {@link User }
     * {@link Conference }
     * {@link Number }
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
     * Gets the value of the callerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallerId() {
        return callerId;
    }

    /**
     * Sets the value of the callerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallerId(String value) {
        this.callerId = value;
    }

    /**
     * Gets the value of the hideCallerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHideCallerId() {
        return hideCallerId;
    }

    /**
     * Sets the value of the hideCallerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHideCallerId(String value) {
        this.hideCallerId = value;
    }

    /**
     * Gets the value of the callerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallerName() {
        return callerName;
    }

    /**
     * Sets the value of the callerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallerName(String value) {
        this.callerName = value;
    }

    /**
     * Gets the value of the dialMusic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDialMusic() {
        return dialMusic;
    }

    /**
     * Sets the value of the dialMusic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDialMusic(String value) {
        this.dialMusic = value;
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
     * Gets the value of the confirmSound property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmSound() {
        return confirmSound;
    }

    /**
     * Sets the value of the confirmSound property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmSound(String value) {
        this.confirmSound = value;
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
     * Gets the value of the straightToVm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStraightToVm() {
        return straightToVm;
    }

    /**
     * Sets the value of the straightToVm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStraightToVm(String value) {
        this.straightToVm = value;
    }

    /**
     * Gets the value of the heartbeatUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeartbeatUrl() {
        return heartbeatUrl;
    }

    /**
     * Sets the value of the heartbeatUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeartbeatUrl(String value) {
        this.heartbeatUrl = value;
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

    /**
     * Gets the value of the forwardedFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForwardedFrom() {
        return forwardedFrom;
    }

    /**
     * Sets the value of the forwardedFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForwardedFrom(String value) {
        this.forwardedFrom = value;
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
     * Gets the value of the recordDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordDirection() {
        return recordDirection;
    }

    /**
     * Sets the value of the recordDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordDirection(String value) {
        this.recordDirection = value;
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
     * Gets the value of the recordLifetime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRecordLifetime() {
        return recordLifetime;
    }

    /**
     * Sets the value of the recordLifetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRecordLifetime(BigInteger value) {
        this.recordLifetime = value;
    }

    /**
     * Gets the value of the recordFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordFormat() {
        return recordFormat;
    }

    /**
     * Sets the value of the recordFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordFormat(String value) {
        this.recordFormat = value;
    }

    /**
     * Gets the value of the ifMachine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfMachine() {
        return ifMachine;
    }

    /**
     * Sets the value of the ifMachine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfMachine(String value) {
        this.ifMachine = value;
    }

    /**
     * Gets the value of the ifMachineUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfMachineUrl() {
        return ifMachineUrl;
    }

    /**
     * Sets the value of the ifMachineUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfMachineUrl(String value) {
        this.ifMachineUrl = value;
    }

    /**
     * Gets the value of the ifMachineMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfMachineMethod() {
        return ifMachineMethod;
    }

    /**
     * Sets the value of the ifMachineMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfMachineMethod(String value) {
        this.ifMachineMethod = value;
    }

    /**
     * Gets the value of the outboundAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutboundAction() {
        return outboundAction;
    }

    /**
     * Sets the value of the outboundAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutboundAction(String value) {
        this.outboundAction = value;
    }

}
