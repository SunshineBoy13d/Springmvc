package cn.api.controller;


import cn.dao.UserBasisDao;
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
@RequestMapping("/api/user/**")
public class UserController {
    @Autowired
    private UserBasisServiceimp userBasisServiceimp;
    @ResponseBody
    @RequestMapping(value = "get",produces="application/json;charset=UTF-8",method = {RequestMethod.GET})
    public String get(@RequestParam("id")int id){
        int code=-1;
        String msg="";
        UserBasis entity=userBasisServiceimp.getEntity(id);
        try{
            if(entity!=null){
                code=1;
                msg="请求成功";
            }
        }catch (Exception e){

        }
        Map<String, Object> res=new HashMap<String,Object>();
        res.put("code",code);
        res.put("msg",msg);
        res.put("entity",entity);
        return new Gson().toJson(res);
    }
}
