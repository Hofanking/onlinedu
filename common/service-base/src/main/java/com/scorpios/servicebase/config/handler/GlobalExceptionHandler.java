package com.scorpios.servicebase.config.handler;

import com.scorpios.common.utils.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse error(Exception e){
        e.printStackTrace();
        return CommonResponse.error().message("全局异常执行。。。。");
    }
}
