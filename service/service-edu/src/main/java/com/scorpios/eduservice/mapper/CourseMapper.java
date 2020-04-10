package com.scorpios.eduservice.mapper;

import com.scorpios.eduservice.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
}
