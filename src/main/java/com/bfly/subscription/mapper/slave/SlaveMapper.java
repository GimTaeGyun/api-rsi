package com.bfly.subscription.mapper.slave;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SlaveMapper {
    public String testQuery();
}
