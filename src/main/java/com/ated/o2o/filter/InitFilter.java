package com.ated.o2o.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ated.o2o.common.constant.LoginConstant;
import com.ated.o2o.common.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  全局过滤器
 * @author zengwx
 */
@Slf4j
public class InitFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        JSONObject error = new JSONObject();
        httpResponse.setHeader("Content-type", "text/html;charset=UTF-8");


        /**解决跨域问题**/
        // 这里填写你允许进行跨域的主机ip
        httpResponse.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        // 允许的访问方法
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET");
        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

        String requestUrl = request.getRequestURI();

        try {
//            session = request.getSession();
            if(requestUrl.contains("swagger") || requestUrl.contains("v2")){
                chain.doFilter(request, httpResponse);
                return;
            }else if(requestUrl.contains(".css") ||
                requestUrl.contains(".js") ||
                requestUrl.contains(".png") ||
                requestUrl.contains(".jpg") ||
                requestUrl.contains(".ico") ||
                requestUrl.contains(".html") ||
                requestUrl.contains(".txt")) {
                chain.doFilter(request, httpResponse);
                return;
            } else {
                log.info("登录认证: " + requestUrl);
                if(requestUrl.contains("sw")){
                    httpResponse.sendRedirect("/oms-other/swagger-ui.html");
                    return;
                }
                if(requestUrl.contains("CF946E2B") ||
                    requestUrl.contains("actuator") ||
                    requestUrl.contains("error")){
                    chain.doFilter(request, httpResponse);
                    return;
                }
//                String token = request.getHeader("Authorization");
//                if(CommonUtil.isEmpty(token)){
//                    log.error("token不能为空");
//                    error.put("code", LoginConstant.TOKEN_ERROR);
//                    error.put("msg", "token过期，请重新登录");
//                    httpResponse.getWriter().write(JSON.toJSONString(error));
//                    return;
//                }
            }
        } catch (Exception e) {
            log.error("身份认证失败", e);
            error.put("code", LoginConstant.NOT_LOGIN);
            error.put("msg", "未知错误，请重新登录");
            httpResponse.getWriter().write(JSON.toJSONString(error));
            return;
        }
        chain.doFilter(request, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
