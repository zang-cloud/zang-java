package com.zang.api.params;

import com.zang.api.domain.enums.AvailableNumberType;

/**
 * Utility class for executing the List Available Numbers request.
 * @see com.zang.api.connectors.AvailablePhoneNumbersConnector
 * @see ListAvailableNumbersParams
 */
public class ListAvailableNumbersParamsBuilder {
    private String accountSid;
    private String country;
    private AvailableNumberType type;
    private String contains;
    private String areaCode;
    private String inRegion;
    private String inPostalCode;
    private Integer page;
    private Integer pageSize;

    ListAvailableNumbersParamsBuilder() {
    }

    public ListAvailableNumbersParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    public ListAvailableNumbersParamsBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public ListAvailableNumbersParamsBuilder setType(AvailableNumberType type) {
        this.type = type;
        return this;
    }

    public ListAvailableNumbersParamsBuilder setContains(String contains) {
        this.contains = contains;
        return this;
    }

    public ListAvailableNumbersParamsBuilder setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public ListAvailableNumbersParamsBuilder setInRegion(String inRegion) {
        this.inRegion = inRegion;
        return this;
    }

    public ListAvailableNumbersParamsBuilder setInPostalCode(String inPostalCode) {
        this.inPostalCode = inPostalCode;
        return this;
    }

    public ListAvailableNumbersParamsBuilder setPage(Integer page) {
        this.page = page;
        return this;
    }

    public ListAvailableNumbersParamsBuilder setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public ListAvailableNumbersParams build() {
        return new ListAvailableNumbersParams(accountSid, country, type, contains, areaCode, inRegion, inPostalCode, page, pageSize);
    }
}