package com.scorpios.cmsservice.service;

import com.scorpios.cmsservice.entity.Banner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author scorpios
 * @since 2020-04-11
 */
public interface BannerService extends IService<Banner> {

    //查询所有banner
    List<Banner> selectAllBanner();
}
