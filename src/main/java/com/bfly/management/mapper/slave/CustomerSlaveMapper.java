package com.bfly.management.mapper.slave;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerSlaveMapper {
    public String testQuery();

    public HashMap<String, Object> selectLogin(@Param("p_id") String p_id );

    public HashMap<String, Object> checkCustomer(HashMap<String, Object> parameter);

    public String selectCustList(HashMap<String, Object> parameter);

    public String selectCustDetailList(HashMap<String, Object> parameter);

}
