package com.bfly.management.customermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfly.management.mapper.master.CustomerMasterMapper;
import com.bfly.management.mapper.slave.CustomerSlaveMapper;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 
 */
@Service
public class BaseService {
    @Autowired
    CustomerMasterMapper masterMapper;

    @Autowired
    CustomerSlaveMapper slaveMapper;

    @Autowired
    ObjectMapper objectMapper;

}
