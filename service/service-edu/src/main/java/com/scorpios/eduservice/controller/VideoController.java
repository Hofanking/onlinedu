package com.scorpios.eduservice.controller;


import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.entity.Video;
import com.scorpios.eduservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 添加小节
    @PostMapping("addVideo")
    public CommonResponse addVideo(@RequestBody Video video) {
        videoService.save(video);
        return CommonResponse.ok();
    }

    //删除小节
    // TODO 后面这个方法需要完善：删除小节时候，同时把里面视频删除
    @DeleteMapping("{id}")
    public CommonResponse deleteVideo(@PathVariable String id) {
        videoService.removeById(id);
        return CommonResponse.ok();
    }

    //修改小节 TODO
}

