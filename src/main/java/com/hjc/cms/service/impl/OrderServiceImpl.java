package com.hjc.cms.service.impl;
import java.util.List;


import com.hjc.cms.bean.entity.OrderReportCount;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.pojo.TOrder;
import com.hjc.cms.bean.pojo.TOrderExample;
import com.hjc.cms.dao.mapper.TOrderMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;



import com.hjc.cms.service.OrderService;
import org.springframework.stereotype.Service;


/**
 * hjc_cms
 * Mr.liuchengming
 * 2020-01-03 10:35
 **/
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TOrderMapper orderMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TOrder> findAll() {
		return orderMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TOrder> page=   (Page<TOrder>) orderMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TOrder order) {
		orderMapper.insert(order);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TOrder order){
		orderMapper.updateByPrimaryKey(order);
	}	
	
	/**
	 * 根据ID获取实体
	 */
	@Override
	public TOrder findOne(String id){
		return orderMapper.selectByPrimaryKey(id);
	}


	/**
	 * 查询页面
	 */
	@Override
	public PageResult findPage(TOrder order, String startTimeStamp,String outTimeStamp,int pageNum, int pageSize,String[] parkIds){
		PageHelper.startPage(pageNum, pageSize);
		
		TOrderExample example=new TOrderExample();
		TOrderExample.Criteria criteria = example.createCriteria();

		if(order!=null){
            if(order.getNotifyStatus() !=null){
                criteria.andNotifyStatusEqualTo(order.getNotifyStatus());
            }
            if(order.getPayStatus() != null){
                criteria.andPayStatusEqualTo(order.getPayStatus());
            }
			if(StringUtils.isNotBlank( order.getCarNumber())){
				criteria.andCarNumberLike("%"+order.getCarNumber()+"%");
			}

			if(order.getTPark() != null && StringUtils.isNotBlank(order.getTPark().getParkName())){
				criteria.andParkNameLike("%"+order.getTPark().getParkName().trim()+"%");
			}

			if(order.getTPark() != null && StringUtils.isNotBlank(order.getTPark().getParkId())){
				example.setParkId(order.getTPark().getParkId());
			}
			}

			if(StringUtils.isNotBlank(startTimeStamp )){
				example.setStartTimeStamp(startTimeStamp);
			}
			if(StringUtils.isNotBlank(outTimeStamp )){
				example.setOutTimeStamp(outTimeStamp);
		     }
            if (parkIds != null){
            	example.setParkIds(parkIds);
			}
		example.setOrderByClause("time_stamp DESC");
		Page<TOrder> page= (Page<TOrder>)orderMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 查询订单报表
	 */
	@Override
	public PageResult findReport(TOrder tOrder, String startTimeStamp, String outTimeStamp, Integer exportType,int[] payFlags,boolean payFlagsNotIn,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TOrderExample example=new TOrderExample();
		if(tOrder != null){
		TOrderExample.Criteria criteria = example.createCriteria();

		}
		if(StringUtils.isNotBlank(startTimeStamp)){
			example.setStartTimeStamp(startTimeStamp);
		}
		if(StringUtils.isNotBlank(outTimeStamp)){
			example.setOutTimeStamp(outTimeStamp);
		}
		if(payFlags != null && payFlags.length > 0){
			example.setPayFlags(payFlags);
		}

		if(payFlagsNotIn){
			example.setPayFlagsNotIn(payFlagsNotIn);
		}

         //总数与银联
		Page<OrderReportCount> page = (Page<OrderReportCount>) orderMapper.selectReportSumCountByExample(example);
			//支付宝微信总数
		PageHelper.startPage(pageNum, pageSize);
		//其他总数

		return new PageResult(page.getTotal(),page.getResult());
	}

}
