package com.scorpios.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.entity.Course;
import com.scorpios.eduservice.entity.Teacher;
import com.scorpios.eduservice.service.CourseService;
import com.scorpios.eduservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eduService/font")
@CrossOrigin
public class IndexFrontController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    //查询前8条热门课程，查询前4条名师
    @GetMapping("/index")
    public CommonResponse index() {
        //查询前8条热门课程
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        wrapper.last("limit 8");
        List<Course> eduList = courseService.list(wrapper);

        //查询前4条名师
        QueryWrapper<Teacher> wrapperTeacher = new QueryWrapper<>();
        wrapperTeacher.orderByDesc("id");
        wrapperTeacher.last("limit 4");
        List<Teacher> teacherList = teacherService.list(wrapperTeacher);

        return CommonResponse.ok().data("eduList",eduList).data("teacherList",teacherList);
    }

}
