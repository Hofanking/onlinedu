package com.scorpios.eduservice.service.impl;

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

}
