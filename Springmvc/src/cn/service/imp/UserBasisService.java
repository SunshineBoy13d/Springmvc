package cn.service.imp;

import cn.model.UserBasis;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserBasisService {
    //增加
    public void Save(UserBasis entity);
    //根据id删除
    public void Delete(int id);
    //根据ID查询
    public UserBasis getEntity(int id);
    //查找全部
    public List<UserBasis> getListUser();
}
