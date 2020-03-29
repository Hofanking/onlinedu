package com.scorpios.eduservice.controller;


import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.entity.Teacher;
import com.scorpios.eduservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CommonResponse findAll(){
        List result = teacherService.list(null);
        return CommonResponse.ok().data("list",result);
    }

    @DeleteMapping("/{id}")
    public CommonResponse removeById(@PathVariable String id){
        return CommonResponse.ok().data("result",true);
    }

}

