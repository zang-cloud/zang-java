package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "Record")
public class Record implements ResponseElement {

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


    public String getContent() {
        return content;
    }


    public void setContent(String value) {
        this.content = value;
    }


    public String getAction() {
        return action;
    }


    public void setAction(String value) {
        this.action = value;
    }


    public String getMethod() {
        return method;
    }


    public void setMethod(String value) {
        this.method = value;
    }


    public BigInteger getTimeout() {
        return timeout;
    }


    public void setTimeout(BigInteger value) {
        this.timeout = value;
    }


    public String getFinishOnKey() {
        return finishOnKey;
    }


    public void setFinishOnKey(String value) {
        this.finishOnKey = value;
    }


    public BigInteger getMaxLength() {
        return maxLength;
    }


    public void setMaxLength(BigInteger value) {
        this.maxLength = value;
    }


    public String getTranscribe() {
        return transcribe;
    }


    public void setTranscribe(String value) {
        this.transcribe = value;
    }


    public String getTranscribeCallback() {
        return transcribeCallback;
    }


    public void setTranscribeCallback(String value) {
        this.transcribeCallback = value;
    }


    public String getTranscribeQuality() {
        return transcribeQuality;
    }


    public void setTranscribeQuality(String value) {
        this.transcribeQuality = value;
    }


    public BigInteger getSliceStart() {
        return sliceStart;
    }


    public void setSliceStart(BigInteger value) {
        this.sliceStart = value;
    }


    public BigInteger getSliceDuration() {
        return sliceDuration;
    }


    public void setSliceDuration(BigInteger value) {
        this.sliceDuration = value;
    }


    public String getPlayBeep() {
        return playBeep;
    }


    public void setPlayBeep(String value) {
        this.playBeep = value;
    }


    public String getBothLegs() {
        return bothLegs;
    }


    public void setBothLegs(String value) {
        this.bothLegs = value;
    }


    public String getFileFormat() {
        return fileFormat;
    }


    public void setFileFormat(String value) {
        this.fileFormat = value;
    }


    public String getDirection() {
        return direction;
    }


    public void setDirection(String value) {
        this.direction = value;
    }


    public String getBackground() {
        return background;
    }


    public void setBackground(String value) {
        this.background = value;
    }


    public BigInteger getSampleRate() {
        return sampleRate;
    }


    public void setSampleRate(BigInteger value) {
        this.sampleRate = value;
    }


    public String getTrimSilence() {
        return trimSilence;
    }


    public void setTrimSilence(String value) {
        this.trimSilence = value;
    }


    public BigInteger getLifetime() {
        return lifetime;
    }


    public void setLifetime(BigInteger value) {
        this.lifetime = value;
    }

}
