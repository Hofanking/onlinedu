package com.scorpios.vod.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.scorpios.common.utils.CommonResponse;
import com.scorpios.servicebase.config.handler.MyException;
import com.scorpios.vod.Utils.ConstantVodUtils;
import com.scorpios.vod.Utils.InitVodCilent;
import com.scorpios.vod.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/eduVod/video")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    //上传视频到阿里云
    @PostMapping("/uploadAilynVideo")
    public CommonResponse uploadAilynVideo(MultipartFile file) {
        //返回上传视频id
        String videoId = vodService.uploadAilynVideo(file);
        return CommonResponse.ok().data("videoId",videoId);
    }

    //根据视频id删除阿里云视频
    @DeleteMapping("/removeAlyVideo/{id}")
    public CommonResponse removeAlyVideo(@PathVariable String id) {
        try {
            //初始化对象
            DefaultAcsClient client = InitVodCilent.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            //创建删除视频request对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            //向request设置视频id
            request.setVideoIds(id);
            //调用初始化对象的方法实现删除
            client.getAcsResponse(request);
            return CommonResponse.ok();
        }catch(Exception e) {
            e.printStackTrace();
            throw new MyException(20001,"删除视频失败");
        }
    }

    //删除多个阿里云视频的方法
    //参数多个视频id  List videoIdList
    @DeleteMapping("deleteBatch")
    public CommonResponse deleteBatch(@RequestParam("videoIdList") List<String> videoIdList) {
        vodService.removeMoreAlyVideo(videoIdList);
        return CommonResponse.ok();
    }
}
