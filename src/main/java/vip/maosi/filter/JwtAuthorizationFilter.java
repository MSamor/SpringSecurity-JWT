package vip.maosi.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import vip.maosi.util.JWTUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 * @description 过滤器处理所有HTTP请求，并检查是否存在带有正确令牌的Authorization标头。例如，如果令牌未过期或签名密钥正确。
 */
@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {


    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String token = request.getHeader("Authorization");
        if (token == null) {
            SecurityContextHolder.clearContext();
            chain.doFilter(request, response);
            return;
        }
//        String tokenValue = token.replace("Bearer ", "");
        UsernamePasswordAuthenticationToken authentication = null;
        try {
            //验证正确性
            JWTUtil.verifyToken(token);
            authentication = JWTUtil.getAuthentication(token);
        } catch (Exception e) {
            logger.error("Invalid jwt : " + e.getMessage());
            chain.doFilter(request, response);
            return;
        }
        System.out.println("角色信息："+authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
}


