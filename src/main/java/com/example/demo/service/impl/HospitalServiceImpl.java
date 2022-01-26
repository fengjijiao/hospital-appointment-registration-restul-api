package com.example.demo.service.impl;

import com.example.demo.entity.Hospital;
import com.example.demo.mapper.HospitalMapper;
import com.example.demo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hospitalServiceImpl")
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;
    @Override
    public boolean save(Hospital queryParamDTO) {
        return hospitalMapper.save(queryParamDTO);
    }

    @Override
    public boolean removeById(Long id) {
        return hospitalMapper.removeById(id);
    }

    @Override
    public boolean update(Hospital queryParamDTO) {
        return hospitalMapper.save(queryParamDTO);
    }

    @Override
    public List<Hospital> pageList(Hospital queryParamDTO, int page, int limit) {
        return hospitalMapper.pageList(queryParamDTO, page, limit);
    }

    @Override
    public List<Hospital> list(Hospital queryParamDTO) {
        return hospitalMapper.list(queryParamDTO);
    }

    @Override
    public Hospital getOne(Hospital queryParamDTO) {
        return hospitalMapper.getOne(queryParamDTO);
    }

    @Override
    public Hospital getById(Long id) {
        return hospitalMapper.getById(id);
    }

    @Override
    public int countList(Hospital queryParamDTO) {
        return hospitalMapper.countList(queryParamDTO);
    }
}
