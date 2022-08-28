package com.bfly.management.mapper.slave;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminSlaveMapper {
    
    // public HashMap selectTest();

    public ArrayList<HashMap> selectCoin();
    // public String selectCoin();

}
