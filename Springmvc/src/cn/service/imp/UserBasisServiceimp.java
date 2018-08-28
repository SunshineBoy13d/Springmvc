package cn.service.imp;

import cn.cache.UserBasisCache;
import cn.dao.UserBasisDao;
import cn.model.UserBasis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBasisServiceimp implements UserBasisService{

    public UserBasisServiceimp(){
        System.out.println("UserBasisServiceimp");
    }
    @Autowired
    private UserBasisCache userBasisCache;
    @Autowired
    private UserBasisDao userBasisDao;
    //增加
    @Override
    public void Save(UserBasis entity){
        int id=entity.getId();
        userBasisDao.Save(entity);
        userBasisCache.set(entity);
    }
    //根据id删除
    @Override
    public void Delete(int id){
        userBasisDao.Delete(id);
        userBasisCache.delete(id);
    }
    //根据ID查询
    @Override
    public UserBasis getEntity(int id){
        return userBasisCache.get(id);
    }
    //查询全部
    @Override
    public List<UserBasis> getListUser(){
        return userBasisDao.getList();
    }
}
