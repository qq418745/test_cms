package com.hjc.cms.dao.mapper;
import com.hjc.cms.bean.pojo.TParkCar;
import com.hjc.cms.bean.pojo.TParkCarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mr.wayne on 2020/1/9 16:05.
 */
public interface TParkCarMapper {
    int countByExample(TParkCarExample example);

    int deleteByExample(TParkCarExample example);

    int deleteByPrimaryKey(String id);

    int insert(TParkCar record);

    int insertSelective(TParkCar record);

    List<TParkCar> selectByExample(TParkCarExample example);

    TParkCar selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TParkCar record, @Param("example") TParkCarExample example);

    int updateByExample(@Param("record") TParkCar record, @Param("example") TParkCarExample example);

    int updateByPrimaryKeySelective(TParkCar record);

    int updateByPrimaryKey(TParkCar record);
}