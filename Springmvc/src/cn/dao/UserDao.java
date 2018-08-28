package cn.dao;


import cn.model.UserBasis;

import java.util.List;

public interface UserDao {
    //增加
    public void Save(UserBasis entity);
    //根据id删除
    public void Delete(int id);
    //根据ID查询
    public UserBasis getEntity(int id);
    //获取全部
    public List<UserBasis> getList();
}
