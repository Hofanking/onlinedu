package com.scorpios.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.entity.Teacher;
import com.scorpios.eduservice.entity.vo.TeacherQuery;
import com.scorpios.eduservice.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
    @GetMapping("/getAllTeacher")
    public CommonResponse getAllTeacher(){
        List result = teacherService.list(null);
        return CommonResponse.ok().data("list",result);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("/removeTeacher/{id}")
    public CommonResponse removeTeacherById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){
        return CommonResponse.ok().data("result",true);
    }


    @ApiOperation(value = "分页讲师列表")
    @GetMapping("/pageTeacherList/{page}/{limit}")
    public CommonResponse pageTeacherList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit
    ){
        Page pageParam = new Page(page,limit);
        teacherService.page(pageParam,null);
        List<Teacher> list = pageParam.getRecords();
        long total = pageParam.getTotal();
        return CommonResponse.ok().data("total",total).data("list",list);
    }

    @ApiOperation(value = "带条件的分页讲师列表")
    @PostMapping("/pageTeacherListByCondition/{page}/{limit}")
    public CommonResponse pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            @RequestBody TeacherQuery teacherQuery
    ){
        Page queryParam = new Page(page,limit);
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level) ) {
            queryWrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_create", end);
        }
        teacherService.page(queryParam,queryWrapper);
        List<Teacher> list = queryParam.getRecords();
        long total = queryParam.getTotal();
        return CommonResponse.ok().data("total",total).data("list",list);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("/saveTeacher")
    public CommonResponse saveTeacher(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){
        teacherService.save(teacher);
        return CommonResponse.ok();
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("/getTeacher/{id}")
    public CommonResponse getTeacherById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        return CommonResponse.ok().data("item", teacher);
    }

    @ApiOperation(value = "根据ID修改讲师")
    @PostMapping("/updateTeacher/{id}")
    public CommonResponse updateTeacherById(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){
        teacherService.updateById(teacher);
        return CommonResponse.ok();
    }

}

