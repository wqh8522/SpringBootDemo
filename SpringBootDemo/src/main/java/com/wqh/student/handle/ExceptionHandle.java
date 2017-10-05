package com.wqh.student.handle;

import com.wqh.student.Utils.ResultUtil;
import com.wqh.student.entity.ResponseResult;
import com.wqh.student.enums.ResultEnum;
import com.wqh.student.exception.StudentExceprion;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created By wqh
 * 2017/9/24   15:09
 * Description:
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult handle(Exception e){
        if(e instanceof StudentExceprion){
            StudentExceprion studentExceprion = (StudentExceprion) e;
            return ResultUtil.error(studentExceprion.getCode(),studentExceprion.getMessage());
        }else {

            return ResultUtil.error(ResultEnum.UNKNOW_ERROR.getCode(),ResultEnum.UNKNOW_ERROR.getMessage());
        }
    }
}
