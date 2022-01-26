package com.example.demo.service.impl;

import com.example.demo.entity.Appointment;
import com.example.demo.mapper.AppointmentMapper;
import com.example.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appointmentServiceImpl")
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public boolean save(Appointment queryParamDTO) {
        return appointmentMapper.save(queryParamDTO);
    }

    @Override
    public boolean remove(Appointment queryParamDTO) {
        return appointmentMapper.remove(queryParamDTO);
    }

    @Override
    public boolean removeById(Long id) {
        return appointmentMapper.removeById(id);
    }

    @Override
    public boolean update(Appointment queryParamDTO) {
        return appointmentMapper.update(queryParamDTO);
    }

    @Override
    public List<Appointment> pageList(Appointment queryParamDTO, int page, int limit) {
        return appointmentMapper.pageList(queryParamDTO, page, limit);
    }

    @Override
    public List<Appointment> list(Appointment queryParamDTO) {
        return appointmentMapper.list(queryParamDTO);
    }

    @Override
    public List<Appointment> validList(Long timestamp) {
        return appointmentMapper.validList(timestamp);
    }

    @Override
    public Appointment getOne(Appointment queryParamDTO) {
        return appointmentMapper.getOne(queryParamDTO);
    }

    @Override
    public Appointment getById(Long id) {
        return appointmentMapper.getById(id);
    }

    @Override
    public int countList(Appointment queryParamDTO) {
        return appointmentMapper.countList(queryParamDTO);
    }
}
