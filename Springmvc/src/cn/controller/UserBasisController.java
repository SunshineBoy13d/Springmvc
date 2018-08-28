package cn.controller;

import cn.actibemq.MessageSender;
import cn.dao.UserBasisDao;
import cn.model.UserBasis;
import cn.service.imp.UserBasisServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserBasisController {

    @Autowired
    private MessageSender messageSender;
    @Autowired
    private UserBasisServiceimp userBasisServiceimp;
    @ResponseBody
    @RequestMapping("/userbasis")
    public String Usertest(){
        UserBasis user=new UserBasis();
        user=userBasisServiceimp.getEntity(1);
        String str;
        if(userBasisServiceimp.getEntity(1)==null){
            return null;
        }else {
            str = "Id:" + user.getId() + "  username:" + user.getUsername() + "  mobile:" + user.getMobile();
            //把信息发送到消息队列
            messageSender.userLogin(user.getId(),user.getUsername());
            System.out.println(str);
        }
        return  str;
    }
}
