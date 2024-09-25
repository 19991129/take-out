package com.demo.takeout.pojo.dto;

import java.util.Arrays;

public class BaseQueryValue {
    private String opt;
    private Object[] values;

    public BaseQueryValue() {
    }

    public String getOpt() {
        return this.opt;
    }

    public Object[] getValues() {
        return this.values;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseQueryValue)) {
            return false;
        } else {
            BaseQueryValue other = (BaseQueryValue)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$opt = this.getOpt();
                Object other$opt = other.getOpt();
                if (this$opt == null) {
                    if (other$opt == null) {
                        return Arrays.deepEquals(this.getValues(), other.getValues());
                    }
                } else if (this$opt.equals(other$opt)) {
                    return Arrays.deepEquals(this.getValues(), other.getValues());
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseQueryValue;
    }

    public int hashCode() {
        int result = 1;
        Object $opt = this.getOpt();
        result = result * 59 + ($opt == null ? 43 : $opt.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getValues());
        return result;
    }

    public String toString() {
        return "BaseQueryValue(opt=" + this.getOpt() + ", values=" + Arrays.deepToString(this.getValues()) + ")";
    }
}
