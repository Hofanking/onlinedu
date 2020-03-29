package com.scorpios.eduservice.controller;

import com.scorpios.eduservice.service.EduTeacherService;
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
public class EduTeacherController {


    @Autowired
    EduTeacherService eduTeacherService;

    @GetMapping("/all")
    public List findAll(){
        List result = eduTeacherService.list(null);
        return result;
    }

}

