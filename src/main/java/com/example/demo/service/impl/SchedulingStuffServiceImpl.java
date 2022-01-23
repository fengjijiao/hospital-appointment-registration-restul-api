package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.SchedulingStuff;
import com.example.demo.mapper.SchedulingStuffMapper;
import com.example.demo.service.SchedulingStuffService;
import org.springframework.stereotype.Service;

@Service("schedulingStuffServiceImpl")
public class SchedulingStuffServiceImpl extends ServiceImpl<SchedulingStuffMapper, SchedulingStuff> implements SchedulingStuffService {
}
