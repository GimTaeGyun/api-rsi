package com.bfly.subscription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfly.subscription.mapper.master.MasterMapper;
import com.bfly.subscription.mapper.slave.SlaveMapper;


/**
 * 
 */
@Service
public class BaseService {
    @Autowired
    MasterMapper masterMapper;

    @Autowired
    SlaveMapper slaveMapper;
}
