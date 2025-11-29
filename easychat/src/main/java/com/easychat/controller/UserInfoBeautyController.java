package com.easychat.controller;

import com.easychat.entity.vo.ResponseVO;
import com.easychat.entity.po.UserInfoBeauty;
import com.easychat.entity.query.UserInfoBeautyQuery;
import com.easychat.service.UserInfoBeautyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:靓号表
Controller
 * @author:lhc
 * @date:2025/12/04
*/
@RestController
@RequestMapping("/userInfoBeauty")
public class UserInfoBeautyController extends ABaseController {

	@Resource
	 private UserInfoBeautyService userInfoBeautyService;

	/**
	 * 根据条件分页查询
	*/
	@RequestMapping("loadDataList")
	public ResponseVO loadDataList(UserInfoBeautyQuery query) {
		return getSuccessResponseVO(userInfoBeautyService.findListByPage(query));
	}

	/**
	 * 新增
	*/
	@RequestMapping("add")
	public ResponseVO add(UserInfoBeauty bean) {
		this.userInfoBeautyService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	*/
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<UserInfoBeauty> listBean) {
		this.userInfoBeautyService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	*/
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<UserInfoBeauty> listBean) {
		this.userInfoBeautyService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}


	/**
	 * 根据Id查询
	*/
	@RequestMapping("getUserInfoBeautyById")
	public ResponseVO getUserInfoBeautyById(Integer id) {
		return getSuccessResponseVO(this.userInfoBeautyService.getUserInfoBeautyById(id));
	}

	/**
	 * 根据Id更新
	*/
	@RequestMapping("updateUserInfoBeautyById")
	public ResponseVO updateUserInfoBeautyById(UserInfoBeauty bean, Integer id) {
		this.userInfoBeautyService.updateUserInfoBeautyById(bean, id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	*/
	@RequestMapping("deleteUserInfoBeautyById")
	public ResponseVO deleteUserInfoBeautyById(Integer id) {
		this.userInfoBeautyService.deleteUserInfoBeautyById(id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据UserId查询
	*/
	@RequestMapping("getUserInfoBeautyByUserId")
	public ResponseVO getUserInfoBeautyByUserId(String userId) {
		return getSuccessResponseVO(this.userInfoBeautyService.getUserInfoBeautyByUserId(userId));
	}

	/**
	 * 根据UserId更新
	*/
	@RequestMapping("updateUserInfoBeautyByUserId")
	public ResponseVO updateUserInfoBeautyByUserId(UserInfoBeauty bean, String userId) {
		this.userInfoBeautyService.updateUserInfoBeautyByUserId(bean, userId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据UserId删除
	*/
	@RequestMapping("deleteUserInfoBeautyByUserId")
	public ResponseVO deleteUserInfoBeautyByUserId(String userId) {
		this.userInfoBeautyService.deleteUserInfoBeautyByUserId(userId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Email查询
	*/
	@RequestMapping("getUserInfoBeautyByEmail")
	public ResponseVO getUserInfoBeautyByEmail(String email) {
		return getSuccessResponseVO(this.userInfoBeautyService.getUserInfoBeautyByEmail(email));
	}

	/**
	 * 根据Email更新
	*/
	@RequestMapping("updateUserInfoBeautyByEmail")
	public ResponseVO updateUserInfoBeautyByEmail(UserInfoBeauty bean, String email) {
		this.userInfoBeautyService.updateUserInfoBeautyByEmail(bean, email);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Email删除
	*/
	@RequestMapping("deleteUserInfoBeautyByEmail")
	public ResponseVO deleteUserInfoBeautyByEmail(String email) {
		this.userInfoBeautyService.deleteUserInfoBeautyByEmail(email);
		return getSuccessResponseVO(null);
	}
}