package com.bfly.management.mapper.master;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductMasterMapper {
    
    public HashMap<String, Object> setProduct(HashMap<String, Object> parameter);

    public HashMap<String, Object> setOptionCategory(HashMap<String, Object> parameter);
}
