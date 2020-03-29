package com.scorpios.eduservice.controller;


import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.entity.Teacher;
import com.scorpios.eduservice.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author scorpios
 * @since 2020-03-29
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduService/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("/all")
    public CommonResponse findAll(){
        List result = teacherService.list(null);
        return CommonResponse.ok().data("list",result);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("/{id}")
    public CommonResponse removeById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){
        return CommonResponse.ok().data("result",true);
    }

}

