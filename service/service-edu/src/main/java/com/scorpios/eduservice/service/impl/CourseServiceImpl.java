package com.scorpios.eduservice.service.impl;

import com.scorpios.eduservice.entity.Course;
import com.scorpios.eduservice.entity.CourseDescription;
import com.scorpios.eduservice.entity.vo.CourseInfoVo;
import com.scorpios.eduservice.mapper.CourseMapper;
import com.scorpios.eduservice.service.CourseDescriptionService;
import com.scorpios.eduservice.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scorpios.servicebase.config.handler.GlobalExceptionHandler;
import com.scorpios.servicebase.config.handler.MyException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author scorpios
 * @since 2020-04-07
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    //课程描述注入
    @Autowired
    private CourseDescriptionService courseDescriptionService;

    //添加课程基本信息的方法
    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        //1 向课程表添加课程基本信息
        //CourseInfoVo对象转换eduCourse对象
        Course eduCourse = new Course();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if(insert == 0) {
            //添加失败
            throw new MyException(20001,"添加课程信息失败");
        }

        //获取添加之后课程id
        String cid = eduCourse.getId();

        //2 向课程简介表添加课程简介
        // edu_course_description
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        //设置描述id就是课程id
        courseDescription.setId(cid);
        courseDescriptionService.save(courseDescription);
        return cid;
    }
}
