package vip.maosi.entity.response;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseCover {
    //拦截器返回体
    public static <T> void responseResult(HttpServletResponse response, ResEntity<T> result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
