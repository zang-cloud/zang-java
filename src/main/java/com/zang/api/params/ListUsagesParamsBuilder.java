package com.zang.api.params;

import com.zang.api.domain.enums.Product;

public class ListUsagesParamsBuilder {
    private String accountSid;
    private Integer day;
    private Integer month;
    private Integer year;
    private Product product;
    private Integer page;
    private Integer pageSize;

    ListUsagesParamsBuilder() {
    }

    public ListUsagesParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    public ListUsagesParamsBuilder setDay(Integer day) {
        this.day = day;
        return this;
    }

    public ListUsagesParamsBuilder setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public ListUsagesParamsBuilder setYear(Integer year) {
        this.year = year;
        return this;
    }

    public ListUsagesParamsBuilder setProduct(Product product) {
        this.product = product;
        return this;
    }

    public ListUsagesParamsBuilder setPage(Integer page) {
        this.page = page;
        return this;
    }

    public ListUsagesParamsBuilder setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public ListUsagesParams build() {
        return new ListUsagesParams(accountSid, day, month, year, product, page, pageSize);
    }
}