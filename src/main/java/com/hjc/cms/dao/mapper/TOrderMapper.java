package com.hjc.cms.dao.mapper;

import com.hjc.cms.bean.entity.MapResult;
import com.hjc.cms.bean.entity.OrderReportCount;
import com.hjc.cms.bean.pojo.TOrder;
import com.hjc.cms.bean.pojo.TOrderExample;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hjc_cms
 * Mr.liuchengming
 * 2020-01-03 10:35
 **/
public interface TOrderMapper {
    int countByExample(TOrderExample example);

    int deleteByExample(TOrderExample example);

    int deleteByPrimaryKey(String outTradeNo);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    List<TOrder> selectByExample(TOrderExample example);

    TOrder selectByPrimaryKey(String outTradeNo);

    /**
     * @return  订单报表统计结果
     */
    List<OrderReportCount> selectReportSumCountByExample(TOrderExample example);

    /**
     * @return 订单支付渠道类型
     */
   List<MapResult> findChargeTypeByExample(String[]  parkIds);
    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);

    List<MapResult> findOrdeMoneyrWeekParkIds(String[] parkids);
}