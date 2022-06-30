package com.bfly.management.mapper.slave;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerSlaveMapper {
    public String testQuery();
}
