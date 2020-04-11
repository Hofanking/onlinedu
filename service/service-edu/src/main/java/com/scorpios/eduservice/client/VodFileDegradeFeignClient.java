package com.scorpios.eduservice.client;

import com.scorpios.common.utils.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VodFileDegradeFeignClient implements VodClient {
   //出错之后会执行
    @Override
    public CommonResponse removeAlyVideo(String id) {
        return CommonResponse.error().message("删除视频出错了");
    }

    @Override
    public CommonResponse deleteBatch(List<String> videoIdList) {
        return CommonResponse.error().message("删除多个视频出错了");
    }
}
