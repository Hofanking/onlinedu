package com.scorpios.eduservice.controller;


import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.entity.vo.CourseInfoVo;
import com.scorpios.eduservice.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author scorpios
 * @since 2020-04-07
 */
@Api(description = "课程管理")
@RestController
@RequestMapping("/eduService/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //添加课程基本信息的方法
    @PostMapping("addCourseInfo")
    public CommonResponse addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        //返回添加之后课程id，为了后面添加大纲使用
        String id = courseService.saveCourseInfo(courseInfoVo);
        return CommonResponse.ok().data("courseId",id);
    }

}

