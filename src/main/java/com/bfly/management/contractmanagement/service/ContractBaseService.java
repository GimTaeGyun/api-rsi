package com.bfly.management.contractmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfly.management.mapper.master.ContractMasterMapper;
import com.bfly.management.mapper.slave.ContractSlaveMapper;


/**
 * 
 */
@Service
public class ContractBaseService {
    @Autowired
    ContractMasterMapper masterMapper;

    @Autowired
    ContractSlaveMapper slaveMapper;
}