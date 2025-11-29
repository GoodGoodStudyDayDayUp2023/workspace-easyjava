package com.easychat.controller;

import com.easychat.entity.vo.ResponseVO;
import com.easychat.entity.po.UserContactApply;
import com.easychat.entity.query.UserContactApplyQuery;
import com.easychat.service.UserContactApplyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:联系人申请Controller
 * @author:lhc
 * @date:2025/12/04
*/
@RestController
@RequestMapping("/userContactApply")
public class UserContactApplyController extends ABaseController {

	@Resource
	 private UserContactApplyService userContactApplyService;

	/**
	 * 根据条件分页查询
	*/
	@RequestMapping("loadDataList")
	public ResponseVO loadDataList(UserContactApplyQuery query) {
		return getSuccessResponseVO(userContactApplyService.findListByPage(query));
	}

	/**
	 * 新增
	*/
	@RequestMapping("add")
	public ResponseVO add(UserContactApply bean) {
		this.userContactApplyService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	*/
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<UserContactApply> listBean) {
		this.userContactApplyService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	*/
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<UserContactApply> listBean) {
		this.userContactApplyService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}


	/**
	 * 根据ApplyId查询
	*/
	@RequestMapping("getUserContactApplyByApplyId")
	public ResponseVO getUserContactApplyByApplyId(Integer applyId) {
		return getSuccessResponseVO(this.userContactApplyService.getUserContactApplyByApplyId(applyId));
	}

	/**
	 * 根据ApplyId更新
	*/
	@RequestMapping("updateUserContactApplyByApplyId")
	public ResponseVO updateUserContactApplyByApplyId(UserContactApply bean, Integer applyId) {
		this.userContactApplyService.updateUserContactApplyByApplyId(bean, applyId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ApplyId删除
	*/
	@RequestMapping("deleteUserContactApplyByApplyId")
	public ResponseVO deleteUserContactApplyByApplyId(Integer applyId) {
		this.userContactApplyService.deleteUserContactApplyByApplyId(applyId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ApplyUserIdAndReceiveUserIdAndContactId查询
	*/
	@RequestMapping("getUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId")
	public ResponseVO getUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(String applyUserId, String receiveUserId, String contactId) {
		return getSuccessResponseVO(this.userContactApplyService.getUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(applyUserId, receiveUserId, contactId));
	}

	/**
	 * 根据ApplyUserIdAndReceiveUserIdAndContactId更新
	*/
	@RequestMapping("updateUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId")
	public ResponseVO updateUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(UserContactApply bean, String applyUserId, String receiveUserId, String contactId) {
		this.userContactApplyService.updateUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(bean, applyUserId, receiveUserId, contactId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ApplyUserIdAndReceiveUserIdAndContactId删除
	*/
	@RequestMapping("deleteUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId")
	public ResponseVO deleteUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(String applyUserId, String receiveUserId, String contactId) {
		this.userContactApplyService.deleteUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(applyUserId, receiveUserId, contactId);
		return getSuccessResponseVO(null);
	}
}