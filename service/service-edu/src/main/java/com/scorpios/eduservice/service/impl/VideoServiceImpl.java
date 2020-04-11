package com.scorpios.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scorpios.eduservice.entity.Video;
import com.scorpios.eduservice.mapper.VideoMapper;
import com.scorpios.eduservice.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author scorpios
 * @since 2020-04-07
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    //1 根据课程id删除小节
    // TODO 删除小节，删除对应视频文件
    @Override
    public void removeVideoByCourseId(String courseId) {
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        baseMapper.delete(wrapper);
    }
}
