package com.scorpios.eduservice.service;

import com.scorpios.eduservice.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scorpios.eduservice.entity.vo.CourseInfoVo;
import com.scorpios.eduservice.entity.vo.CoursePublishVo;

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
}
