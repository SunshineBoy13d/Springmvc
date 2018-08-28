package cn.controller;

import cn.dao.UserBasisDao;
import cn.interceptor.Authority;
import cn.interceptor.AuthorityType;
import cn.model.UserBasis;
import cn.service.imp.UserBasisServiceimp;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@Authority(AuthorityType.NoAuthority)
@RequestMapping("/account/**")
public class AccountController {
    @Autowired
    private UserBasisServiceimp userBasisServiceimp;
    @Authority(AuthorityType.Validate)
    @ResponseBody
    @RequestMapping(value = "log" ,produces = "application/json;charset=UTF-8", method = { RequestMethod.POST })
    public String log(@RequestParam("id") int id){
            int code=-1;
            String msg="";
        UserBasis userBasis=userBasisServiceimp.getEntity(id);
            if(userBasis==null){
                msg="用户不存在";
            }else {
                code=1;
                msg="登陆成功！";
            }
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("code", code);
        responseMap.put("msg", msg);
        responseMap.put("userbasis",userBasis);
        return new Gson().toJson(responseMap);
    }
}
