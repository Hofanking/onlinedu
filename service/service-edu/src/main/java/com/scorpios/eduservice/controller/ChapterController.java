package com.scorpios.eduservice.controller;


import com.scorpios.common.utils.CommonResponse;
import com.scorpios.eduservice.entity.Chapter;
import com.scorpios.eduservice.entity.chapter.ChapterVo;
import com.scorpios.eduservice.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author scorpios
 * @since 2020-04-07
 */
@RestController
@RequestMapping("/eduService/chapter")
@CrossOrigin
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    //课程大纲列表,根据课程id进行查询
    @GetMapping("getChapterVideo/{courseId}")
    public CommonResponse getChapterVideo(@PathVariable String courseId) {
        List<ChapterVo> list = chapterService.getChapterVideoByCourseId(courseId);
        return CommonResponse.ok().data("allChapterVideo",list);
    }

    //添加章节
    @PostMapping("addChapter")
    public CommonResponse addChapter(@RequestBody Chapter Chapter) {
        chapterService.save(Chapter);
        return CommonResponse.ok();
    }

    //根据章节id查询
    @GetMapping("getChapterInfo/{chapterId}")
    public CommonResponse getChapterInfo(@PathVariable String chapterId) {
        Chapter chapter = chapterService.getById(chapterId);
        return CommonResponse.ok().data("chapter",chapter);
    }

    //修改章节
    @PostMapping("updateChapter")
    public CommonResponse updateChapter(@RequestBody Chapter Chapter) {
        chapterService.updateById(Chapter);
        return CommonResponse.ok();
    }

    //删除的方法
    @DeleteMapping("{chapterId}")
    public CommonResponse deleteChapter(@PathVariable String chapterId) {
        boolean flag = chapterService.deleteChapter(chapterId);
        if(flag) {
            return CommonResponse.ok();
        } else {
            return CommonResponse.error();
        }

    }

}

