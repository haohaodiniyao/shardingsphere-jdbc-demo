package com.example.controller;

import com.example.mapper.TOrder;
import com.example.mapper.TOrderExample;
import com.example.mapper.TOrderMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/")
public class HelloController {
    @Resource
    private TOrderMapper tOrderMapper;
    @RequestMapping("/query")
    public TOrder query(){
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        TOrderExample tOrderExample = new TOrderExample();
        TOrderExample.Criteria criteria = tOrderExample.createCriteria();
        criteria.andOrderIdEqualTo(19);
        criteria.andUserIdEqualTo(19);
        List<TOrder> list = tOrderMapper.selectByExample(tOrderExample);
        return list.get(0);
    }
}
