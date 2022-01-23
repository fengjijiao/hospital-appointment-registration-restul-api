package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Hospital;
import com.example.demo.mapper.HospitalMapper;
import com.example.demo.service.HospitalService;
import org.springframework.stereotype.Service;

@Service("hospitalServiceImpl")
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements HospitalService {
}
