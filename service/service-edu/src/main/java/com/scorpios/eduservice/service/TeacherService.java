package com.scorpios.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scorpios.eduservice.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author scorpios
 * @since 2020-03-29
 */
public interface TeacherService extends IService<Teacher> {
    //1 分页查询讲师的方法
    Map<String, Object> getTeacherFrontList(Page<Teacher> pageTeacher);
}
