package cn.cache;

import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemcachedBasis {
    @Autowired
    protected MemcachedClient memcachedClient;

    //失效时间一天
    protected int Exptime = 3600 * 24;

    // 基础数据失效时间一周
    protected int DataExptime = this.Exptime * 7;

    protected String Prefix = "Spring demo:";
}
