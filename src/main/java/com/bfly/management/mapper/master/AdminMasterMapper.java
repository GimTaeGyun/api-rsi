package com.bfly.management.mapper.master;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMasterMapper {
    
    public HashMap<String, Object> setUser(HashMap<String, Object> parameter);

    public HashMap<String, Object> delMoveUser(HashMap<String, Object> parameter);

    public int updateUserPw(HashMap<String, Object> parameter);

    public HashMap<String, Object> setUserGroup(HashMap<String, Object> parameter);
}
