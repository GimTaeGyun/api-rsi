package com.bfly.management.productmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfly.management.mapper.master.ProductMasterMapper;
import com.bfly.management.mapper.slave.ProductSlaveMapper;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 
 */
@Service
public class ProductBaseService {
    @Autowired
    ProductMasterMapper masterMapper;

    @Autowired
    ProductSlaveMapper slaveMapper;

    @Autowired
    ObjectMapper objectMapper;
}
