package com.hjc.cms.service;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.pojo.TOrder;

import java.util.List;



/**
 * hjc_cms
 * Mr.liuchengming
 * 2020-01-03 10:35
 **/
public interface OrderService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TOrder> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TOrder order);
	
	
	/**
	 * 修改
	 */
	public void update(TOrder order);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TOrder findOne(String id);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TOrder order,String startTimeStamp ,String outTimeStamp,int pageNum, int pageSize,String[] parkIds);


	/**
	 * 查询报表接口
	 */
	public PageResult findReport(TOrder tOrder, String startTimeStamp, String outTimeStamp, Integer exportType,int[] payFlags,boolean payFlagsNotIn,int pageNum, int pageSize);
}
