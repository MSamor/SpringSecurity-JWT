package vip.maosi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @description 资源
 **/
@RestController
@RequestMapping("/api")
@Api(tags = "认证测试")
public class ApiController {

    /**
     * 权限控制，需要hasAuthority中的权限
     * @return
     */
    @PostMapping("/auth/aaa")
    @ApiOperation("登录测试")
    @PreAuthorize("hasAuthority('ADMINs')")
    public String login() {
        System.out.println("登录成功");
        return "登录成功";
    }

    /**
     * 权限控制测试，不需要权限
     * @return
     */
    @PostMapping("/auth/bbb")
    @ApiOperation("测试")
    public String login2() {
        System.out.println("登录成功");
        return "登录成功";
    }

}
