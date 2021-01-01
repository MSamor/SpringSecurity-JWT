package vip.maosi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.maosi.util.JWTUtil;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @description 资源
 **/
@RestController
@RequestMapping("/api")
@Api(tags = "认证测试")
public class ApiController {

    @PostMapping("/auth/aaa")
    @ApiOperation("登录测试")
    //权限控制
    @PreAuthorize("hasAuthority('ADMINs')")
    public String login() {
        System.out.println("登录成功");
        return "登录成功";
    }

    @PostMapping("/auth/bb")
    @ApiOperation("测试")
    //权限控制
    public String login2() {
        System.out.println("登录成功");
        return "登录成功";
    }

}
