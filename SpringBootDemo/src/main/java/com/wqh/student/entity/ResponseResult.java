package com.wqh.student.entity;

/**
 * Created By wqh
 * 2017/9/24 002414:43
 * Description: 相应结果的处理
 */
public class ResponseResult<T> {

   /** 响应码 */
    private Integer code;

    /** 响应信息 */
    private String message;

    /** 数据 */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
