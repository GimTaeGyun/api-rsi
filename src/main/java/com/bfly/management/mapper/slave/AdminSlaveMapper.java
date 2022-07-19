package com.bfly.management.mapper.slave;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminSlaveMapper {

    public HashMap<String, Object> selectAdminLogin(HashMap<String, Object> parameter);
    
}
