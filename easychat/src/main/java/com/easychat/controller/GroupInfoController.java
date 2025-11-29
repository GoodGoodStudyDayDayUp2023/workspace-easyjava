package com.easychat.controller;

import com.easychat.entity.vo.ResponseVO;
import com.easychat.entity.po.GroupInfo;
import com.easychat.entity.query.GroupInfoQuery;
import com.easychat.service.GroupInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:Controller
 * @author:lhc
 * @date:2025/12/04
*/
@RestController
@RequestMapping("/groupInfo")
public class GroupInfoController extends ABaseController {

	@Resource
	 private GroupInfoService groupInfoService;

	/**
	 * 根据条件分页查询
	*/
	@RequestMapping("loadDataList")
	public ResponseVO loadDataList(GroupInfoQuery query) {
		return getSuccessResponseVO(groupInfoService.findListByPage(query));
	}

	/**
	 * 新增
	*/
	@RequestMapping("add")
	public ResponseVO add(GroupInfo bean) {
		this.groupInfoService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	*/
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<GroupInfo> listBean) {
		this.groupInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	*/
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<GroupInfo> listBean) {
		this.groupInfoService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}


	/**
	 * 根据GroupId查询
	*/
	@RequestMapping("getGroupInfoByGroupId")
	public ResponseVO getGroupInfoByGroupId(String groupId) {
		return getSuccessResponseVO(this.groupInfoService.getGroupInfoByGroupId(groupId));
	}

	/**
	 * 根据GroupId更新
	*/
	@RequestMapping("updateGroupInfoByGroupId")
	public ResponseVO updateGroupInfoByGroupId(GroupInfo bean, String groupId) {
		this.groupInfoService.updateGroupInfoByGroupId(bean, groupId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据GroupId删除
	*/
	@RequestMapping("deleteGroupInfoByGroupId")
	public ResponseVO deleteGroupInfoByGroupId(String groupId) {
		this.groupInfoService.deleteGroupInfoByGroupId(groupId);
		return getSuccessResponseVO(null);
	}
}