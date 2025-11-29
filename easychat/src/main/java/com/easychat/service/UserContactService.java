package com.easychat.service;

import com.easychat.entity.vo.PaginationResultVO;
import com.easychat.entity.po.UserContact;
import com.easychat.entity.query.UserContactQuery;
import java.util.List;

/**
 * @Description:联系人Service
 * @author:lhc
 * @date:2025/12/04
*/
public interface UserContactService{

	/**
	 * 根据条件查询列表
	*/
	List<UserContact> findListByParam(UserContactQuery query);

	/**
	 * 根据条件查询数量
	*/
	Integer findCountByParam(UserContactQuery query);

	/**
	 * 分页查询
	*/
	PaginationResultVO<UserContact> findListByPage(UserContactQuery query);

	/**
	 * 新增
	*/
	Integer add(UserContact bean);

	/**
	 * 批量新增
	*/
	Integer addBatch(List<UserContact> listBean);

	/**
	 * 批量新增/修改
	*/
	Integer addOrUpdateBatch(List<UserContact> listBean);


	/**
	 * 多条件更新
	 */
	Integer updateByParam(UserContact bean,UserContactQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(UserContactQuery param);
	/**
	 * 根据UserIdAndContactId查询
	*/
	UserContact getUserContactByUserIdAndContactId(String userId, String contactId);

	/**
	 * 根据UserIdAndContactId更新
	*/
	Integer updateUserContactByUserIdAndContactId( UserContact bean, String userId, String contactId);

	/**
	 * 根据UserIdAndContactId删除
	*/
	Integer deleteUserContactByUserIdAndContactId(String userId, String contactId);


}