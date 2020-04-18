package com.scorpios.eduservice.mapper;

import com.scorpios.eduservice.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scorpios.eduservice.entity.frontvo.CourseWebVo;
import com.scorpios.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author scorpios
 * @since 2020-04-07
 */
public interface CourseMapper extends BaseMapper<Course> {
    public CoursePublishVo getPublishCourseInfo(String courseId);

    //根据课程id，编写sql语句查询课程信息
    CourseWebVo getBaseCourseInfo(String courseId);
}
