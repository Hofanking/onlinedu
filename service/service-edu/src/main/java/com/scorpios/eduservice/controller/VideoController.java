package com.scorpios.eduservice.controller;


import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.client.VodClient;
import com.scorpios.eduservice.entity.Video;
import com.scorpios.eduservice.service.VideoService;
import com.scorpios.servicebase.config.handler.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author scorpios
 * @since 2020-04-07
 */
@RestController
@RequestMapping("/eduService/video")
@CrossOrigin
public class VideoController {

    @Autowired
    private VideoService videoService;

    //注入vodClient
    @Autowired
    private VodClient vodClient;

    // 添加小节
    @PostMapping("addVideo")
    public CommonResponse addVideo(@RequestBody Video video) {
        videoService.save(video);
        return CommonResponse.ok();
    }

    // 删除小节时候，同时把里面视频删除
    @DeleteMapping("{id}")
    public CommonResponse deleteVideo(@PathVariable String id) {
        //根据小节id获取视频id，调用方法实现视频删除
        Video eduVideo = videoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();
        //判断小节里面是否有视频id
        if(!StringUtils.isEmpty(videoSourceId)) {
            //根据视频id，远程调用实现视频删除
            CommonResponse result = vodClient.removeAlyVideo(videoSourceId);
            if(result.getCode() == 20001) {
                throw new MyException(20001,"删除视频失败，熔断器...");
            }
        }

        videoService.removeById(id);
        return CommonResponse.ok();
    }

    //修改小节 TODO
}

