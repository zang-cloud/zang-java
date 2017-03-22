package com.zang.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import java.math.BigDecimal;

public class CarrierLookup extends BaseZangObject {

    @JsonProperty(value = "phone_number")
    private String phoneNumber;
    private String network;
    private Boolean mobile;
    @JsonProperty(value = "carrier_id")
    private String carrierId;
    @JsonProperty(value = "country_code")
    private String countryCode;
    private String mnc;
    private String mcc;
    private BigDecimal price;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
