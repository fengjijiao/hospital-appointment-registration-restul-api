package com.example.demo.service.impl;

import com.example.demo.entity.Doctor;
import com.example.demo.mapper.DoctorMapper;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("doctorServiceImpl")
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public boolean save(Doctor queryParamDTO) {
        return doctorMapper.save(queryParamDTO);
    }

    @Override
    public boolean removeById(Long id) {
        return doctorMapper.removeById(id);
    }

    @Override
    public boolean update(Doctor queryParamDTO) {
        return doctorMapper.update(queryParamDTO);
    }

    @Override
    public List<Doctor> pageList(Doctor queryParamDTO, int page, int limit) {
        return doctorMapper.pageList(queryParamDTO, page, limit);
    }

    @Override
    public List<Doctor> list(Doctor queryParamDTO) {
        return doctorMapper.list(queryParamDTO);
    }

    @Override
    public Doctor getOne(Doctor queryParamDTO) {
        return doctorMapper.getOne(queryParamDTO);
    }

    @Override
    public Doctor getById(Long id) {
        return doctorMapper.getById(id);
    }

    @Override
    public int countList(Doctor queryParamDTO) {
        return doctorMapper.countList(queryParamDTO);
    }
}
