package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Scheduling;
import com.example.demo.mapper.SchedulingMapper;
import com.example.demo.service.SchedulingService;
import org.springframework.stereotype.Service;

@Service("schedulingServiceImpl")
public class SchedulingServiceImpl extends ServiceImpl<SchedulingMapper, Scheduling> implements SchedulingService {
}
