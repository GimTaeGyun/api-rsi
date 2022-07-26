package com.bfly.management.mapper.master;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerMasterMapper {

    public HashMap<String, Object> createCustomer(HashMap<String, Object> parameter);
    
    /**
	 * 트랜잭션 처리를 위한 함수 새로 정의
	 */
	void startTransaction();
	void commit();
	void rollback();
}
