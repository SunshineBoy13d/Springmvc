package cn.model;



import org.apache.ibatis.session.SqlSessionFactory;

import java.io.Serializable;
import java.util.Date;

public class UserBasis implements Serializable {

private  int id;
private  String username;
private  long mobile;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public long getMobile() {
        return mobile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
    @Override
    public String toString(){
        return "id: "+id+" username:"+username+" mobile:"+mobile;
    }
}
