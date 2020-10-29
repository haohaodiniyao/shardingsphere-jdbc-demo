package com.example;

import com.example.mapper.*;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ShardingsphereJdbcDemoApplicationTests {

    @Resource
    private TOrderMapper tOrderMapper;

    @Resource
    private TOrderItemMapper tOrderItemMapper;

    @Test
    void contextLoads() {
//        TOrder tOrder = new TOrder();
//        tOrder.setOrderId(19);
//        tOrder.setUserId(19);
//        tOrder.setStatus("19");
//        tOrderMapper.insertSelective(tOrder);

//        TOrderItem tOrderItem = new TOrderItem();
//        tOrderItem.setOrderId(19);
//        tOrderItem.setUserId(19);
//        tOrderItem.setStatus("19");
//        tOrderItemMapper.insertSelective(tOrderItem);

        HintManager hintManager = HintManager.getInstance();
        //走主库
        hintManager.setMasterRouteOnly();
        TOrderExample tOrderExample = new TOrderExample();
        TOrderExample.Criteria criteria = tOrderExample.createCriteria();
        criteria.andOrderIdEqualTo(19);
        criteria.andUserIdEqualTo(19);
        List<TOrder> list = tOrderMapper.selectByExample(tOrderExample);
        System.out.println(list.get(0).getOrderId());
    }

}
