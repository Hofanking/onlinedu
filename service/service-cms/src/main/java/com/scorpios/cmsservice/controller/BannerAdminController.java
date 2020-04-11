package com.scorpios.cmsservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scorpios.cmsservice.entity.Banner;
import com.scorpios.cmsservice.service.BannerService;
import com.scorpios.common.utils.CommonResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author scorpios
 * @since 2020-04-11
 * 管理员使用接口
 */
@RestController
@RequestMapping("/cmsService/admin/banner")
@CrossOrigin
public class BannerAdminController {

    @Autowired
    private BannerService bannerService;

    //1 分页查询banner
    @GetMapping("pageBanner/{page}/{limit}")
    public CommonResponse pageBanner(@PathVariable long page, @PathVariable long limit) {
        Page<Banner> pageBanner = new Page<>(page,limit);
        bannerService.page(pageBanner,null);
        return CommonResponse.ok().data("items",pageBanner.getRecords()).data("total",pageBanner.getTotal());
    }

    //2 添加banner
    @PostMapping("addBanner")
    public CommonResponse addBanner(@RequestBody Banner banner) {
        bannerService.save(banner);
        return CommonResponse.ok();
    }

    @ApiOperation(value = "获取Banner")
    @GetMapping("get/{id}")
    public CommonResponse get(@PathVariable String id) {
        Banner banner = bannerService.getById(id);
        return CommonResponse.ok().data("item", banner);
    }

    @ApiOperation(value = "修改Banner")
    @PutMapping("update")
    public CommonResponse updateById(@RequestBody Banner banner) {
        bannerService.updateById(banner);
        return CommonResponse.ok();
    }

    @ApiOperation(value = "删除Banner")
    @DeleteMapping("remove/{id}")
    public CommonResponse remove(@PathVariable String id) {
        bannerService.removeById(id);
        return CommonResponse.ok();
    }
}

