package com.demo.takeout.pojo.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class BaseSearchParam {
    private Map<String, BaseQueryValue> queryPrams;
    private String sortField;
    private String sortOrder;
    private QueryWrapper wrapper;

    public Map<String, BaseQueryValue> getQueryPrams() {
        if (this.queryPrams == null) {
            this.queryPrams = new HashMap();
        }

        return this.queryPrams;
    }

    public void setQueryPrams(Map<String, BaseQueryValue> queryPrams) {
        this.queryPrams = queryPrams;
    }

    public boolean addQueryParams(String key, BaseQueryValue baseQueryValue) {
        if (!StringUtils.isBlank(key) && baseQueryValue != null) {
            Object[] values = baseQueryValue.getValues();
            if (values != null && values.length != 0) {
                if (this.getQueryPrams().containsKey(key)) {
                    return false;
                } else {
                    this.getQueryPrams().put(key, baseQueryValue);
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public BaseQueryValue peek(String key) {
        BaseQueryValue baseQueryValue = null;
        if (!StringUtils.isBlank(key)) {
            baseQueryValue = (BaseQueryValue)this.getQueryPrams().get(key);
        }

        return baseQueryValue;
    }

    public BaseQueryValue pop(String key) {
        BaseQueryValue baseQueryValue = this.peek(key);
        this.getQueryPrams().remove(key);
        return baseQueryValue;
    }

    public BaseSearchParam() {
    }

    public String getSortField() {
        return this.sortField;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    public QueryWrapper getWrapper() {
        return this.wrapper;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public void setWrapper(QueryWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseSearchParam)) {
            return false;
        } else {
            BaseSearchParam other = (BaseSearchParam)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$queryPrams = this.getQueryPrams();
                    Object other$queryPrams = other.getQueryPrams();
                    if (this$queryPrams == null) {
                        if (other$queryPrams == null) {
                            break label59;
                        }
                    } else if (this$queryPrams.equals(other$queryPrams)) {
                        break label59;
                    }

                    return false;
                }

                Object this$sortField = this.getSortField();
                Object other$sortField = other.getSortField();
                if (this$sortField == null) {
                    if (other$sortField != null) {
                        return false;
                    }
                } else if (!this$sortField.equals(other$sortField)) {
                    return false;
                }

                Object this$sortOrder = this.getSortOrder();
                Object other$sortOrder = other.getSortOrder();
                if (this$sortOrder == null) {
                    if (other$sortOrder != null) {
                        return false;
                    }
                } else if (!this$sortOrder.equals(other$sortOrder)) {
                    return false;
                }

                Object this$wrapper = this.getWrapper();
                Object other$wrapper = other.getWrapper();
                if (this$wrapper == null) {
                    if (other$wrapper != null) {
                        return false;
                    }
                } else if (!this$wrapper.equals(other$wrapper)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseSearchParam;
    }

    public int hashCode() {
        int result = 1;
        Object $queryPrams = this.getQueryPrams();
        result = result * 59 + ($queryPrams == null ? 43 : $queryPrams.hashCode());
        Object $sortField = this.getSortField();
        result = result * 59 + ($sortField == null ? 43 : $sortField.hashCode());
        Object $sortOrder = this.getSortOrder();
        result = result * 59 + ($sortOrder == null ? 43 : $sortOrder.hashCode());
        Object $wrapper = this.getWrapper();
        result = result * 59 + ($wrapper == null ? 43 : $wrapper.hashCode());
        return result;
    }

    public String toString() {
        return "BaseSearchParam(queryPrams=" + this.getQueryPrams() + ", sortField=" + this.getSortField() + ", sortOrder=" + this.getSortOrder() + ", wrapper=" + this.getWrapper() + ")";
    }
}
