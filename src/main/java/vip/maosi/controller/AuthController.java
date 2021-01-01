package vip.maosi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.maosi.entity.response.ResEntity;
import vip.maosi.util.JWTUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @description 认证授权
 **/
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "登录")
public class AuthController {

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResEntity login() {
        Map<String, Object> map = new HashMap<>();
        map.put("role","ADMIN");
        String token = JWTUtil.createToken(map);
        ResEntity result = new ResEntity();
        result.setCode(200).setMsg("登录成功").setData(token);
        return result;
    }
}
