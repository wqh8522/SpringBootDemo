package com.wqh.student.enums;

/**
 * Created By wqh
 * 2017/9/24   15:26
 * Description: 返回结果的枚举类
 */
public enum  ResultEnum {
    UNKNOW_ERROR (-1,"未知错误"),
    SUCCESS(1,"成功"),
    PRIMARY_ERROR(100,"你可能在上小学"),
    MIDDLE_ERROR(101,"你可能在上初中"),
    WORK_ERROR(102,"你可能在打工");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
