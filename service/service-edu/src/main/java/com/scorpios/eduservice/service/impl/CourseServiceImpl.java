package com.scorpios.eduservice.service.impl;

import com.scorpios.eduservice.entity.Course;
import com.scorpios.eduservice.entity.CourseDescription;
import com.scorpios.eduservice.entity.vo.CourseInfoVo;
import com.scorpios.eduservice.entity.vo.CoursePublishVo;
import com.scorpios.eduservice.mapper.CourseMapper;
import com.scorpios.eduservice.service.ChapterService;
import com.scorpios.eduservice.service.CourseDescriptionService;
import com.scorpios.eduservice.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scorpios.eduservice.service.VideoService;
import com.scorpios.servicebase.config.handler.GlobalExceptionHandler;
import com.scorpios.servicebase.config.handler.MyException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author scorpios
 * @since 2020-04-07
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    //课程描述注入
    @Autowired
    private CourseDescriptionService courseDescriptionService;


    //注入小节和章节service
    @Autowired
    private VideoService eduVideoService;

    @Autowired
    private ChapterService chapterService;

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

    //根据课程id查询课程基本信息
    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        //1 查询课程表
        Course eduCourse = baseMapper.selectById(courseId);
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(eduCourse,courseInfoVo);

        //2 查询描述表
        CourseDescription courseDescription = courseDescriptionService.getById(courseId);
        courseInfoVo.setDescription(courseDescription.getDescription());
        return courseInfoVo;
    }

    //修改课程信息
    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        //1 修改课程表
        Course eduCourse = new Course();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int update = baseMapper.updateById(eduCourse);
        if(update == 0) {
            throw new MyException(20001,"修改课程信息失败");
        }

        //2 修改描述表
        CourseDescription description = new CourseDescription();
        description.setId(courseInfoVo.getId());
        description.setDescription(courseInfoVo.getDescription());
        courseDescriptionService.updateById(description);
    }

    //根据课程id查询课程确认信息
    @Override
    public CoursePublishVo publishCourseInfo(String id) {
        //调用mapper
        CoursePublishVo publishCourseInfo = baseMapper.getPublishCourseInfo(id);
        return publishCourseInfo;
    }


    //删除课程
    @Override
    public void removeCourse(String courseId) {
        //1 根据课程id删除小节
        eduVideoService.removeVideoByCourseId(courseId);

        //2 根据课程id删除章节
        chapterService.removeChapterByCourseId(courseId);

        //3 根据课程id删除描述
        courseDescriptionService.removeById(courseId);

        //4 根据课程id删除课程本身
        int result = baseMapper.deleteById(courseId);
        if(result == 0) { //失败返回
            throw new MyException(20001,"删除失败");
        }
    }
}
