package com.bfly.management.rsiupbit.controller;

import com.bfly.management.rsiupbit.service.RsiManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.productmanagement.master.OptionCategoryUpdateReqModel;
import com.bfly.management.model.productmanagement.master.OptionProductUpdateReqModel;
import com.bfly.management.model.productmanagement.master.ProductGroupUpdateReqModel;
import com.bfly.management.model.productmanagement.master.ProductUpdateReqModel;
import com.bfly.management.model.productmanagement.slave.GetOptionCategoryReqModel;
import com.bfly.management.model.productmanagement.slave.ProductItemReqModel;
import com.bfly.management.rsiupbit.service.PmManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api( tags = "RSI 조회 - RSI 조회")
// @RequestMapping(value="/manager", produces = { "application/json" })
// @RequestMapping(produces = { "application/json" })
public class RSIController {
    
    @Autowired
    PmManagerService managerService;

	@Autowired
	RsiManagerService rsiService;

    /**
	 * RSI 조회
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "RSI 조회", notes = "RSI 조회")
	// @GetMapping("/rsi/inquiry")
	@PostMapping("/rsi/inquiry")
	// public ApiResult<?> getRSI(@RequestBody ProductItemReqModel param) throws Exception {
	public ApiResult<?> selectRsi() throws Exception {
	// public String getRSI() throws Exception {

		// managerService.getProduct();
		
		// return "hello";
		return rsiService.selectRsi();
	}

	/**
	 * 거래내역 조회
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "거래내역 조회", notes = "거래내역 조회")
	// @GetMapping("/rsi/inquiry")
	@PostMapping("/trade/inquiry")
	// public ApiResult<?> getRSI(@RequestBody ProductItemReqModel param) throws Exception {
	public ApiResult<?> getProduct() throws Exception {
		// public String getRSI() throws Exception {

		// managerService.getProduct();

		// return "hello";
		return managerService.getProduct();
	}

	/**
	 * RSI 조회
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "RSI 조회", notes = "RSI 조회")
	// @GetMapping("/rsi/inquiry")
	@PostMapping("/menu")
	// public ApiResult<?> getRSI(@RequestBody ProductItemReqModel param) throws Exception {
	public ApiResult<?> selectMenu() throws Exception {
		// public String getRSI() throws Exception {

		// managerService.getProduct();

		// return "hello";
		return managerService.selectMenu();
	}

}
