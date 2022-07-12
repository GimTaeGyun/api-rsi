package com.bfly.management.mapper.slave;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerSlaveMapper {
    public String testQuery();

    public HashMap<String, Object> selectLogin(HashMap<String, Object> parameter);

    public HashMap<String, Object> checkCustomer(HashMap<String, Object> parameter);

}
