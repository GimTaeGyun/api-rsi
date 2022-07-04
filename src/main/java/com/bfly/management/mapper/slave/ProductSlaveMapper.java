package com.bfly.management.mapper.slave;

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

    /**
     * 옵션카테고리 가져오기
     * @param p_opt_cat_id
     * @return
     */
    public String getOptionCategory(@Param("p_opt_cat_id") Integer p_opt_cat_id);

    /**
     * 상품리스트 상세조회
     * @param p_prd_id
     * @return
     */
    public String getProductDetail(@Param("p_prd_id") Integer p_prd_id);
}
