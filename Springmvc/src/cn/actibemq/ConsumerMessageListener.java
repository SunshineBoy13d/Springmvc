package cn.actibemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
//消费者
public class ConsumerMessageListener implements MessageListener {
    public ConsumerMessageListener(){
        System.out.println("consumerMesssss");
    }
    @Override
    public void onMessage(Message mas){
     TextMessage text=(TextMessage)mas;
     try{
         System.out.println(text.getText());
     }catch(JMSException e) {
            e.printStackTrace();
     }
 }
}
