package com.bfly.management.mapper.slave;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminSlaveMapper {

    public HashMap<String, Object> selectAdminLogin(HashMap<String, Object> parameter);
    
    public String selectUser(HashMap<String, Object> parameter);

    public String selectUserPw(@Param("p_usr_id") String p_usr_id);
    
}
