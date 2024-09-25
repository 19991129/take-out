package com.demo.takeout.pojo.dto;


import javax.validation.constraints.NotNull;

public class PageSearchParam extends BaseSearchParam {
    @NotNull
    private int limit = 10;
    @NotNull
    private int page = 1;

    public PageSearchParam() {
    }

    public int getLimit() {
        return this.limit;
    }

    public int getPage() {
        return this.page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageSearchParam)) {
            return false;
        } else {
            PageSearchParam other = (PageSearchParam)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getLimit() != other.getLimit()) {
                return false;
            } else {
                return this.getPage() == other.getPage();
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageSearchParam;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getLimit();
        result = result * 59 + this.getPage();
        return result;
    }

    public String toString() {
        return "PageSearchParam(limit=" + this.getLimit() + ", page=" + this.getPage() + ")";
    }
}
