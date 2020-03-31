package com.scorpios.oss.controller;

import com.scorpios.common.utils.CommonResponse;
import com.scorpios.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduOss/file/oss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    // 上传头像的方法
    @PostMapping
    public CommonResponse uploadOssFile(MultipartFile file) {
        // 获取上传文件MultipartFile
        // 返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);
        return CommonResponse.ok().data("url",url);
    }
}
