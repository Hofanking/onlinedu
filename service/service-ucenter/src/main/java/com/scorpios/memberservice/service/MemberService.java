package com.scorpios.memberservice.service;

import com.scorpios.memberservice.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scorpios.memberservice.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author scorpios
 * @since 2020-04-13
 */
public interface MemberService extends IService<Member> {
    //登录的方法
    String login(Member member);

    //注册的方法
    void register(RegisterVo registerVo);
}
