package com.scorpios.eduservice.service;

import com.scorpios.eduservice.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scorpios.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author scorpios
 * @since 2020-04-02
 */
public interface SubjectService extends IService<Subject> {

    //添加课程分类
    void saveSubject(MultipartFile file, SubjectService subjectService);

    //课程分类列表（树形）
    List<OneSubject> getAllOneTwoSubject();
}
