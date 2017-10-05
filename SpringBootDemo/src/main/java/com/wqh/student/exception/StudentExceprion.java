package com.wqh.student.exception;

import com.wqh.student.enums.ResultEnum;

/**
 * Created By wqh
 * 2017/9/24   15:13
 * Description: 自定义异常，只有继承RuntimeException才能被Spring的hadler捕获
 */
public class StudentExceprion extends RuntimeException{
    private Integer code;

    public StudentExceprion(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
