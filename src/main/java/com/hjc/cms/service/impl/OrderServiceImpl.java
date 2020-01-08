package com.hjc.cms.service.impl;
import java.util.List;

import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.pojo.TOrder;
import com.hjc.cms.bean.pojo.TOrderExample;
import com.hjc.cms.dao.mapper.TOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;



import com.hjc.cms.service.OrderService;
import org.springframework.stereotype.Service;


/**
 * @program: hjc_cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2020-01-03 10:35
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
	 * @param id
	 * @return
	 */
	@Override
	public TOrder findOne(String id){
		return orderMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for(String id:ids){
			orderMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TOrder order, int pageNum, int pageSize) {
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

						if(order.getOutTradeNo()!=null && order.getOutTradeNo().length()>0){
				criteria.andOutTradeNoLike("%"+order.getOutTradeNo()+"%");
			}
			if(order.getTradeNo()!=null && order.getTradeNo().length()>0){
				criteria.andTradeNoLike("%"+order.getTradeNo()+"%");
			}
			if(order.getTPark() != null && order.getTPark().getParkId() != null && order.getTPark().getParkId().length()>0){
				criteria.andParkIdLike("%"+order.getTPark().getParkId()+"%");
			}
			if(order.getCarNumber()!=null && order.getCarNumber().length()>0){
				criteria.andCarNumberLike("%"+order.getCarNumber()+"%");
			}
			if(order.getWatchId()!=null && order.getWatchId().length()>0){
				criteria.andWatchIdLike("%"+order.getWatchId()+"%");
			}

			if(order.getSId()!=null && order.getSId().length()>0){
				criteria.andSIdLike("%"+order.getSId()+"%");
			}
			if(order.getOpenid()!=null && order.getOpenid().length()>0){
				criteria.andOpenidLike("%"+order.getOpenid()+"%");
			}
			if(order.getOpenIdForOwner()!=null && order.getOpenIdForOwner().length()>0){
				criteria.andOpenIdForOwnerLike("%"+order.getOpenIdForOwner()+"%");
			}
			if(order.getEnterTime()!=null && order.getEnterTime().length()>0){
				criteria.andEnterTimeLike("%"+order.getEnterTime()+"%");
			}
			if(order.getDiscountDetail()!=null && order.getDiscountDetail().length()>0){
				criteria.andDiscountDetailLike("%"+order.getDiscountDetail()+"%");
			}
			if(order.getCardId()!=null && order.getCardId().length()>0){
				criteria.andCardIdLike("%"+order.getCardId()+"%");
			}
			if(order.getDueTime()!=null && order.getDueTime().length()>0){
				criteria.andDueTimeLike("%"+order.getDueTime()+"%");
			}
			if(order.getBillId()!=null && order.getBillId().length()>0){
				criteria.andBillIdLike("%"+order.getBillId()+"%");
			}
	
		}
		
		Page<TOrder> page= (Page<TOrder>)orderMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
