package com.bfly.management.mapper.slave;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ContractSlaveMapper {

    /**
     * 장바구니 조회
     * @param p_cust_id
     * @return String
     */
    public String getCartInfo(@Param("p_cust_id") String p_cust_id);
}
