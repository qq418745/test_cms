package com.hjc.cms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.pojo.TParkCar;
import com.hjc.cms.bean.pojo.TParkCarExample;
import com.hjc.cms.dao.mapper.TParkCarMapper;
import com.hjc.cms.service.ParkCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Mr.wayne on 2020/1/9 16:11.
 */
@Service
public class ParkCarServiceImpl implements ParkCarService {

	@Autowired
	private TParkCarMapper parkCarMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TParkCar> findAll() {
		return parkCarMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TParkCar> page=   (Page<TParkCar>) parkCarMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TParkCar parkCar) {
		parkCarMapper.insert(parkCar);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TParkCar parkCar){
		parkCarMapper.updateByPrimaryKey(parkCar);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TParkCar findOne(String id){
		return parkCarMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for(String id:ids){
			parkCarMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TParkCar parkCar, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TParkCarExample example=new TParkCarExample();
			TParkCarExample.Criteria criteria = example.createCriteria();
		
		if(parkCar!=null){
            if(parkCar.getId() !=null){
                criteria.andIdEqualTo(parkCar.getId());
            }
            if(parkCar.getCarNumber() != null){
                criteria.andCarNumberEqualTo(parkCar.getCarNumber());
            }

			if(parkCar.getParkId()!=null && parkCar.getParkId().length()>0){
				criteria.andParkIdLike("%"+parkCar.getParkId()+"%");
			}
			if(parkCar.getEnterTime()!=null){
				criteria.andEnterTimeLike("%"+parkCar.getEnterTime()+"%");
			}
			if(parkCar.getOutTime()!=null){
				criteria.andOutTimeLike("%"+parkCar.getOutTime()+"%");
			}
			if(parkCar.getTPark() != null && parkCar.getTPark().getParkId() != null && parkCar.getTPark().getParkId().length()>0){
				criteria.andParkIdLike("%"+parkCar.getTPark().getParkId()+"%");
			}
			if(parkCar.getOrderId()!=null && parkCar.getOrderId().length()>0){
				criteria.andOrderIdLike("%"+parkCar.getOrderId()+"%");
			}

			if(parkCar.getOperator()!=null && parkCar.getOperator().length()>0){
				criteria.andOperatorLike("%"+parkCar.getOperator()+"%");
			}
			if(parkCar.getDeviceId()!=null && parkCar.getDeviceId().length()>0){
				criteria.andDeviceIdLike("%"+parkCar.getDeviceId()+"%");
			}
		}
		
		Page<TParkCar> page= (Page<TParkCar>)parkCarMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
