package com.bfly.management.mapper.slave;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminSlaveMapper {

    public HashMap<String, Object> selectAdminLogin(@Param("p_id") String p_id);
    
    public String selectUser(HashMap<String, Object> parameter);

    public String selectUserPw(@Param("p_usr_id") String p_usr_id);

    public String selectUserGroup(@Param("p_usr_grp_id") int p_usr_grp_id);
    
}
