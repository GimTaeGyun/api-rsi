package com.bfly.management.mapper.master;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ContractMasterMapper {
    
    public HashMap<String, Object> setCartInfo(HashMap<String, Object> parameter);
}
