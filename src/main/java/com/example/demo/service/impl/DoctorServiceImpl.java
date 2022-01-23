package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Doctor;
import com.example.demo.mapper.DoctorMapper;
import com.example.demo.service.DoctorService;
import org.springframework.stereotype.Service;

@Service("doctorServiceImpl")
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {
}
