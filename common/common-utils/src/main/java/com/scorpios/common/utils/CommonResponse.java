package com.scorpios.common.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CommonResponse {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private CommonResponse(){}

    public static CommonResponse ok(){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(true);
        commonResponse.setCode(ResultCode.SUCCESS);
        commonResponse.setMessage("成功");
        return commonResponse;
    }

    public static CommonResponse error(){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(false);
        commonResponse.setCode(ResultCode.ERROR);
        commonResponse.setMessage("失败");
        return commonResponse;
    }

    public CommonResponse success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public CommonResponse message(String message){
        this.setMessage(message);
        return this;
    }

    public CommonResponse code(Integer code){
        this.setCode(code);
        return this;
    }

    public CommonResponse data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public CommonResponse data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
