package com.scorpios.eduservice.controller;


import com.scorpios.eduservice.entity.Teacher;
import com.scorpios.eduservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author scorpios
 * @since 2020-03-29
 */
@RestController
@RequestMapping("/eduService/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;


    @GetMapping("/all")
    public List<Teacher> findAll(){
        List result = teacherService.list(null);
        return result;
    }

}
