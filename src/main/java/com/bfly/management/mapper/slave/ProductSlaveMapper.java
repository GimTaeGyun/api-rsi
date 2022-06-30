package com.bfly.management.mapper.slave;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface ProductSlaveMapper {
    public String testQuery();

    /**
     * 상품군 가져오기
     * @param sId
     * @return String
     */
    public String getProduct(@Param("sId") Integer sId);

    public String getOptionCategory(@Param("p_opt_cat_id") Integer p_opt_cat_id);
}
