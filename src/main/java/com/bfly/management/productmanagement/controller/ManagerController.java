package com.bfly.management.productmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.productmanagement.master.OptionCategoryUpdateReqModel;
import com.bfly.management.model.productmanagement.master.OptionProductUpdateReqModel;
import com.bfly.management.model.productmanagement.master.ProductUpdateReqModel;
import com.bfly.management.model.productmanagement.slave.GetOptionCategoryReqModel;
import com.bfly.management.model.productmanagement.slave.ProductItemReqModel;
import com.bfly.management.productmanagement.service.ManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api( tags = "Manager API")
@RequestMapping(value="/manager", produces = { "application/json" })
public class ManagerController {
    
    @Autowired
    ManagerService managerService;

    /**
	 * 관리자 상품군 조회
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "상품군 조회", notes = "상품군 조회 ( sid : 서비스 ID )")
	@PostMapping("/productgroup/inquiry")
	public ApiResult<?> getProduct(@Valid @RequestBody ProductItemReqModel param) throws Exception {
		return managerService.getProduct(param);
	}

	/**
	 * 관리자 상품그룹 생성 삭제 수정
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "상품그룹 생성, 수정, 삭제", notes = "상품그룹 생성, 수정, 삭제")
	@PostMapping("/productgroup/update")
	public ApiResult<?> updateProduct(@Valid @RequestBody ProductUpdateReqModel param) throws Exception {
		return managerService.updateProduct(param);
	}

	/**
	 * 관리자 옵션카테고리 조회
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "옵션카테고리 조회", notes = "옵션카테고리 조회 ( p_opt_cat_id : 옵션카테고리 ID )")
	@PostMapping("/option/category/inquiry")
	public ApiResult<?> getOptionCategory(@Valid @RequestBody GetOptionCategoryReqModel param) throws Exception {
		return managerService.getOptionCategory(param);
	}

	/**
	 * 관리자 옵션카테고리 생성 삭제 수정
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "옵션카테고리 생성, 수정, 삭제", notes = "옵션카테고리 생성, 수정, 삭제 ( 삭제 파라미터 필수값은 optCatId 나머지는 문자열은 빈값, 정수형은 0으로 입력요망 )")
	@PostMapping("/option/category/update")
	public ApiResult<?> updateOption(@Valid @RequestBody OptionCategoryUpdateReqModel param) throws Exception {
		return managerService.updateOptionCategory(param);
	}

	/**
	 * 관리자 상품옵션 조회
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "상품옵션 조회", notes = "상품옵션 조회")
	@PostMapping("/option/product/inquiry")
	public ApiResult<?> getOptionProduct(@Valid @RequestBody GetOptionCategoryReqModel param) throws Exception {
		return managerService.getOptionProduct(param);
	}

	/**
	 * 관리자 상품옵션 생성 삭제 수정
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "상품옵션 생성, 수정, 삭제", notes = "상품옵션 생성, 수정, 삭제 ")
	@PostMapping("/option/product/update")
	public ApiResult<?> updateOptionProduct(@Valid @RequestBody OptionProductUpdateReqModel param) throws Exception {
		return managerService.updateOptionProduct(param);
	}

}
