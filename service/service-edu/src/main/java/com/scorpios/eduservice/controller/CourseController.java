package com.scorpios.eduservice.controller;


import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.entity.vo.CourseInfoVo;
import com.scorpios.eduservice.entity.vo.CoursePublishVo;
import com.scorpios.eduservice.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author scorpios
 * @since 2020-04-07
 */
@Api(description = "课程管理")
@RestController
@RequestMapping("/eduService/course")
@CrossOrigin
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

    //根据课程id查询课程基本信息
    @GetMapping("getCourseInfo/{courseId}")
    public CommonResponse getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(courseId);
        return CommonResponse.ok().data("courseInfoVo",courseInfoVo);
    }

    //修改课程信息
    @PostMapping("updateCourseInfo")
    public CommonResponse updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        courseService.updateCourseInfo(courseInfoVo);
        return CommonResponse.ok();
    }

    //根据课程id查询课程确认信息
    @GetMapping("getPublishCourseInfo/{id}")
    public CommonResponse getPublishCourseInfo(@PathVariable String id) {
        CoursePublishVo coursePublishVo = courseService.publishCourseInfo(id);
        return CommonResponse.ok().data("publishCourse",coursePublishVo);
    }


}

