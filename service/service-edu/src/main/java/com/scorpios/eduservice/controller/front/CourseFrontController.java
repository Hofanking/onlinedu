package com.scorpios.eduservice.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.entity.Course;
import com.scorpios.eduservice.entity.chapter.ChapterVo;
import com.scorpios.eduservice.entity.frontvo.CourseFrontVo;
import com.scorpios.eduservice.entity.frontvo.CourseWebVo;
import com.scorpios.eduservice.service.ChapterService;
import com.scorpios.eduservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduService/course/front")
@CrossOrigin
public class CourseFrontController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ChapterService chapterService;

    //1 条件查询带分页查询课程
    @PostMapping("getFrontCourseList/{page}/{limit}")
    public CommonResponse getFrontCourseList(@PathVariable long page, @PathVariable long limit,
                                             @RequestBody(required = false) CourseFrontVo courseFrontVo) {
        Page<Course> pageCourse = new Page<>(page,limit);
        Map<String,Object> map = courseService.getCourseFrontList(pageCourse,courseFrontVo);
        //返回分页所有数据
        return CommonResponse.ok().data(map);
    }

    //2 课程详情的方法
    @GetMapping("getFrontCourseInfo/{courseId}")
    public CommonResponse getFrontCourseInfo(@PathVariable String courseId) {
        //根据课程id，编写sql语句查询课程信息
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);

        //根据课程id查询章节和小节
        List<ChapterVo> chapterVideoList = chapterService.getChapterVideoByCourseId(courseId);

        return CommonResponse.ok().data("courseWebVo",courseWebVo).data("chapterVideoList",chapterVideoList);
    }
}












