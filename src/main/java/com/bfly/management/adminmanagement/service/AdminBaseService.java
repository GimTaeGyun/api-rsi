package com.bfly.management.adminmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfly.management.mapper.master.AdminMasterMapper;
import com.bfly.management.mapper.master.ContractMasterMapper;
import com.bfly.management.mapper.slave.AdminSlaveMapper;
import com.bfly.management.mapper.slave.ContractSlaveMapper;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 
 */
@Service
public class AdminBaseService {

    @Autowired
    AdminMasterMapper masterMapper;

    @Autowired
    AdminSlaveMapper slaveMapper;

    @Autowired
    ObjectMapper objectMapper;
}
