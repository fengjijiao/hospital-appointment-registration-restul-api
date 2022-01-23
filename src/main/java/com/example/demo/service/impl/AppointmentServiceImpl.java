package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Appointment;
import com.example.demo.mapper.AppointmentMapper;
import com.example.demo.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service("appointmentServiceImpl")
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {
}
