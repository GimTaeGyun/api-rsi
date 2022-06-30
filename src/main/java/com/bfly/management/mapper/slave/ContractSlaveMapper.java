package com.bfly.management.mapper.slave;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ContractSlaveMapper {
    public String testQuery();
}
