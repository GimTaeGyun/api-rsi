package com.bfly.management.customermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfly.management.mapper.master.CustomerMasterMapper;
import com.bfly.management.mapper.slave.CustomerSlaveMapper;


/**
 * 
 */
@Service
public class BaseService {
    @Autowired
    CustomerMasterMapper masterMapper;

    @Autowired
    CustomerSlaveMapper slaveMapper;
}
