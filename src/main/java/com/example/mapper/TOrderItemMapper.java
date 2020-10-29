package com.example.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrderItemMapper {
    long countByExample(TOrderItemExample example);

    int deleteByExample(TOrderItemExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(TOrderItem record);

    int insertSelective(TOrderItem record);

    List<TOrderItem> selectByExample(TOrderItemExample example);

    TOrderItem selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") TOrderItem record, @Param("example") TOrderItemExample example);

    int updateByExample(@Param("record") TOrderItem record, @Param("example") TOrderItemExample example);

    int updateByPrimaryKeySelective(TOrderItem record);

    int updateByPrimaryKey(TOrderItem record);
}