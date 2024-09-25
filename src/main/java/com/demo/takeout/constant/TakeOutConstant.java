package com.demo.takeout.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface TakeOutConstant {
//    @EnumType(name = "status")
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    enum StatusEnum {
        WAITCOMMIT("01", "待申请"),
        WAITAPPROVE("02", "待审核"),
        HASAGREE("03", "已同意"),
        HASREJECT("04", "已退回");
        private final String key;
        private final String value;
    }
}
