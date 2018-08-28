package cn.quartz;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//定时任务
@Component
public class GlodQuartz {
    @Scheduled(cron = "*/5 * * * * ? ")
    public void cacheClear() {
        //System.out.println("定时任务");
    }
}
