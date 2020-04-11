package com.scorpios.cmsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scorpios.cmsservice.entity.Banner;
import com.scorpios.cmsservice.mapper.BannerMapper;
import com.scorpios.cmsservice.service.BannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author scorpios
 * @since 2020-04-11
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    //查询所有banner
//    @Cacheable(value = "banner",key = "'selectIndexList'")
    @Override
    public List<Banner> selectAllBanner() {
        //根据id进行降序排列，显示排列之后前两条记录
        QueryWrapper<Banner> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        //last方法，拼接sql语句
        wrapper.last("limit 2");
        List<Banner> list = baseMapper.selectList(null);
        return list;
    }
}
