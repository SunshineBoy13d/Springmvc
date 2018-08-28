package cn.cache;

import cn.dao.UserBasisDao;
import cn.model.UserBasis;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
public class UserBasisCache extends MemcachedBasis {
    public UserBasisCache(){
        System.out.println("UserBasisCache");
    }
    @Autowired
    private UserBasisDao userBasisDao;
    //保存缓存
    public Boolean set(UserBasis model) {
        Boolean result = false;
        try {
            //把缓存添加到memcached里 三个参数分别为 Key 失效时间和 value
            result = memcachedClient.set(getCacheKey(model.getId()), super.Exptime, model);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            System.out.println("设置缓存时出现异常了！！");
        }
        return result;
    }
    //获取缓存
    public UserBasis get(int id) {
        UserBasis entity = new UserBasis();
        try {
            entity = memcachedClient.get(getCacheKey(id));
            //如果缓存找不到就从数据库查找，并且添加到缓存中
            if (entity == null) {
                entity = userBasisDao.getEntity(id);
                this.set(entity);
            }
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            System.out.println("获取缓存时出现异常了！！");
            entity = userBasisDao.getEntity(id);
        }
        return entity;
    }
    //删除缓存
    public Boolean delete(int id) {
        try {
            return memcachedClient.delete(getCacheKey(id));
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            System.out.println("删除缓存时出现异常了!!");
        }
        return false;
    }
    //获取缓存的Key
    private String getCacheKey(int id) {
        return super.Prefix + "UserBasis:" + id;
    }
}
