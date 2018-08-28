package cn.interceptor;


import com.google.gson.Gson;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AuthorityAnnotationInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        if(handler instanceof HandlerMethod){
            HandlerMethod hand=(HandlerMethod)handler;
            Class<?> clazz=hand.getBeanType();
            Method method=hand.getMethod();
            try{
                if(clazz!=null&& method!=null){
                    boolean isClazz=clazz.isAnnotationPresent(Authority.class);
                    boolean ismethod=method.isAnnotationPresent(Authority.class);
                    Authority authority=null;
                    if(isClazz){
                        authority=method.getAnnotation(Authority.class);
                    }else if(ismethod){
                        authority=clazz.getAnnotation(Authority.class);
                    }
                    int code=-1;
                    String msg="";
                    if (authority!=null){
                        if (AuthorityType.NoValidate == authority.value()) {
                            System.out.println("不验证！");
                            // 标记为不验证,放行
                            return true;
                        } else if (AuthorityType.NoAuthority == authority.value()) {
                            System.out.println("是否登陆！");
                            // 不验证权限，验证是否登录
                            return true;
                        } else {
                            // 验证登录及权限
                            System.out.println("验证成功！");
                            code = 1;
                            msg = "验证成功！";
                            return true;
                        }
                    }
                    msg="验证失败！";
                    Map<String, Object> responseMap = new HashMap<String, Object>();
                    responseMap.put("code", code);
                    responseMap.put("msg", msg);
                    String json = new Gson().toJson(responseMap);
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json; charset=utf-8");
                    response.getWriter().write(json);
                    return false;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
     return false;
    }
}
