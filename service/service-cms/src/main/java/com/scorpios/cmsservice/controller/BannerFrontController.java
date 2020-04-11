package com.scorpios.cmsservice.controller;


import com.scorpios.cmsservice.entity.Banner;
import com.scorpios.cmsservice.service.BannerService;
import com.scorpios.common.utils.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author scorpios
 * @since 2020-04-11
 * 用户平台使用接口
 */
@RestController
@RequestMapping("/cmsService/front/banner")
@CrossOrigin
public class BannerFrontController {

    @Autowired
    private BannerService bannerService;

    //查询所有banner
    @GetMapping("/getAllBanner")
    public CommonResponse getAllBanner() {
        List<Banner> list = bannerService.selectAllBanner();
        return CommonResponse.ok().data("list",list);
    }
}

