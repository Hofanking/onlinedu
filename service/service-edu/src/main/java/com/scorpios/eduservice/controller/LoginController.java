package com.scorpios.eduservice.controller;

import com.scorpios.common.utils.CommonResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduService/user")
@CrossOrigin
public class LoginController {

    @PostMapping("/login")
    public CommonResponse login(){
        return CommonResponse.ok().data("token","admin");
    }

    @GetMapping("/info")
    public CommonResponse info(){
        return CommonResponse.ok()
                .data("roles","[admin]")
                .data("name","admin")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

}
