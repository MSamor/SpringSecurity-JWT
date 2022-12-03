package vip.maosi.exception;

import lombok.val;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import vip.maosi.entity.response.ResponseCover;
import vip.maosi.entity.response.ResEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**
     * 当用户尝试访问需要权限才能的REST资源而不提供Token或者Token错误或者过期时，
     * 将调用此方法发送401响应以及错误信息
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        //  response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());

        val result = new ResEntity<>();
        result.setCode(HttpServletResponse.SC_UNAUTHORIZED)
                .setMsg("权限不足,token错误或未携带" + authException.getMessage())
                .setData(null);
        ResponseCover.responseResult(response, result);
    }
}
