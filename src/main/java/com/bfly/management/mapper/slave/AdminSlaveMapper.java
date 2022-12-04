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

    public ArrayList<HashMap> selectMenuId();

    public ArrayList<HashMap> selectMenuByUpp(@Param("menu_id") Integer menu_id);

}
