package com.scorpios.eduservice.controller;


import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.entity.subject.OneSubject;
import com.scorpios.eduservice.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author scorpios
 * @since 2020-04-02
 */
@Api(description = "课程管理")
@RestController
@RequestMapping("/eduService/subject")
@CrossOrigin
public class SubjectController {


    @Autowired
    private SubjectService subjectService;

    //添加课程分类
    @ApiOperation(value = "Excel批量导入")
    @PostMapping("/addSubject")
    public CommonResponse addSubject(MultipartFile file) {
        //1 获取上传的excel文件 MultipartFile
        //返回错误提示信息
        subjectService.saveSubject(file,subjectService);
        //判断返回集合是否为空
        return CommonResponse.ok();
    }

    //课程分类列表（树形）
    @GetMapping("getAllSubject")
    public CommonResponse getAllSubject() {
        //list集合泛型是一级分类
        List<OneSubject> list = subjectService.getAllOneTwoSubject();
        return CommonResponse.ok().data("list",list);
    }

}

