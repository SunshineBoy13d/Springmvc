package cn.dao;

import cn.model.UserBasis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserBasisDao implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserBasisDao(){
        System.out.println("UserBasisDaoCalled");
    }
    @Override
    public void Save(UserBasis entity) {
        try {
                String strSql = "insert into user (id,Username,Mobile) values (?,?,?)";
                Object obj[] = { entity.getId(), entity.getUsername(),entity.getMobile() };
                jdbcTemplate.update(strSql, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //删除
    @Override
    public void Delete(int ID) {
        String strSql = "delete from user where id=?";
        Object obj[] = { ID };
        jdbcTemplate.update(strSql, obj);
    }

  //查找
  @Override
    public UserBasis getEntity(int ID) {
        final UserBasis entity = new UserBasis();
        String strSql = "select * from user where id=?";
        jdbcTemplate.query(strSql, new Object[] { ID }, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                if(rs!=null){
                    entity.setId(rs.getInt("id"));
                    entity.setUsername(rs.getString("username"));
                    entity.setMobile(rs.getLong("mobile"));
                }
            }
        });
        if(entity.getId()<=0){
            return null;
        }
        return entity;
    }
    @Override
    public List<UserBasis> getList() {
        final ArrayList<UserBasis> list = new ArrayList<UserBasis>();
        String strSql = "select * from user ";

        jdbcTemplate.query(strSql, new Object[] {}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                UserBasis entity = new UserBasis();
                entity.setId(rs.getInt("id"));
                entity.setUsername(rs.getString("username"));
                entity.setMobile(rs.getLong("mobile"));
                list.add(entity);
            }
        });
        return list;
    }

}
