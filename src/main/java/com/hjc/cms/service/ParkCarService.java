package com.hjc.cms.service;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.pojo.TOrder;
import com.hjc.cms.bean.pojo.TParkCar;

import java.util.List;


/**
 * Created by Mr.wayne on 2020/1/9 16:11.
 */
public interface ParkCarService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TParkCar> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TParkCar parkCar);
	
	
	/**
	 * 修改
	 */
	public void update(TParkCar parkCar);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TParkCar findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(String[] ids);

	/**
	 * 分
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TParkCar parkCar, int pageNum, int pageSize);
	
}
