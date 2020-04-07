package com.scorpios.eduservice.service;

import com.scorpios.eduservice.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scorpios.eduservice.entity.vo.CourseInfoVo;

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
}
