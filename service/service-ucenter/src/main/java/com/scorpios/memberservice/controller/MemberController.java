package com.scorpios.memberservice.controller;


import com.scorpios.common.utils.CommonResponse;
import com.scorpios.common.utils.JwtUtils;
import com.scorpios.memberservice.entity.Member;
import com.scorpios.memberservice.entity.vo.RegisterVo;
import com.scorpios.memberservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author scorpios
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/memberService/member")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    //登录
    @PostMapping("login")
    public CommonResponse loginUser(@RequestBody Member member) {
        //member对象封装手机号和密码
        //调用service方法实现登录
        //返回token值，使用jwt生成
        String token = memberService.login(member);
        return CommonResponse.ok().data("token",token);
    }

    //注册
    @PostMapping("register")
    public CommonResponse registerUser(@RequestBody RegisterVo registerVo) {
        memberService.register(registerVo);
        return CommonResponse.ok();
    }

    //根据token获取用户信息
    @GetMapping("getMemberInfo")
    public CommonResponse getMemberInfo(HttpServletRequest request) {
        //调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        //查询数据库根据用户id获取用户信息
        Member member = memberService.getById(memberId);
        return CommonResponse.ok().data("userInfo",member);
    }

}

