package cn.actibemq;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import org.apache.activemq.transport.TransportListener;

import java.io.IOException;

public class ActibeMQTransportListener implements TransportListener {
    @Override
    public void onCommand(Object o){


    }
    @Override
    public void onException(IOException e){
        System.out.println("连接错误");
        e.printStackTrace();
    }
    @Override
    public void transportInterupted(){
        System.out.println("消息中断");
    }
    @Override
    public void transportResumed(){
        System.out.println("消息连接恢复");
    }
}
