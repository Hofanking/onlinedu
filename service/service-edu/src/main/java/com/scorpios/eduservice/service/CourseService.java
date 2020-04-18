package com.scorpios.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scorpios.eduservice.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scorpios.eduservice.entity.frontvo.CourseFrontVo;
import com.scorpios.eduservice.entity.frontvo.CourseWebVo;
import com.scorpios.eduservice.entity.vo.CourseInfoVo;
import com.scorpios.eduservice.entity.vo.CoursePublishVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author scorpios
 * @since 2020-04-07
 */
public interface CourseService extends IService<Course> {

    // 添加课程基本信息的方法
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    //根据课程id查询课程基本信息
    CourseInfoVo getCourseInfo(String courseId);

    //修改课程信息
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    //根据课程id查询课程确认信息
    CoursePublishVo publishCourseInfo(String id);

    //删除课程
    void removeCourse(String courseId);

    //1 条件查询带分页查询课程前台
    Map<String, Object> getCourseFrontList(Page<Course> pageCourse, CourseFrontVo courseFrontVo);

    //根据课程id，编写sql语句查询课程信息
    CourseWebVo getBaseCourseInfo(String courseId);
}
