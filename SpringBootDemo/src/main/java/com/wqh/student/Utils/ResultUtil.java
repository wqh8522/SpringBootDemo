package com.wqh.student.Utils;

import com.wqh.student.entity.ResponseResult;
import com.wqh.student.entity.Students;

/**
 * Created By wqh
 * 2017/9/24 14:50
 * Description:返回结果的封装的工具类
 */
public class ResultUtil {
    public static ResponseResult success(Object object){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(1);
        responseResult.setMessage("成功");
        responseResult.setData(object);
        return responseResult;
    }

    public static  ResponseResult success(){
        return success(null);
    }

    public static ResponseResult error(Integer code,String content){
        ResponseResult<Students> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setMessage(content);
        return responseResult;
    }
}
