package com.scorpios.eduservice.service;

import com.scorpios.eduservice.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scorpios.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author scorpios
 * @since 2020-04-07
 */
public interface ChapterService extends IService<Chapter> {

    //课程大纲列表,根据课程id进行查询
    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    //删除章节的方法
    boolean deleteChapter(String chapterId);

    //2 根据课程id删除章节
    void removeChapterByCourseId(String courseId);
}
