package cn.actibemq;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.HashMap;
import java.util.Map;

//生产者
@Component
public class MessageSender {
    public  MessageSender(){
        System.out.println("Messsssssssssss");
    }
    @Autowired
    private JmsTemplate jmsTemplate;
    private  String Queue="default_queue";
    private  String GoldQueue="gold_queue";
    private  Gson gson=new Gson();
    public void userLogin(int id,String username){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",id);
        map.put("username",username);
        System.out.println("发送消息。");
        sendMessage(gson.toJson(map),1);
    }
    public  void sendMessage(final String message,int type){
        try{
            String destination=this.Queue;
            if (type == 1) {
                destination=this.GoldQueue;
            }
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    TextMessage textMessage=session.createTextMessage(message);
                    return textMessage;
                }
            });
            }catch (Exception e){
        }
        }
    }

