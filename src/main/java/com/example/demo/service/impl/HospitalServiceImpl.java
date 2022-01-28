package com.example.demo.service.impl;

import com.example.demo.entity.Hospital;
import com.example.demo.mapper.HospitalMapper;
import com.example.demo.o.qo.PageQO;
import com.example.demo.o.vo.PageVO;
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
    public PageVO<Hospital> pageList(Hospital queryParamDTO, PageQO pageQO) {
        List<Hospital> hospitalList = hospitalMapper.pageList(queryParamDTO, pageQO);
        Integer total = hospitalMapper.countList(queryParamDTO);
        return new PageVO<>(pageQO.getPageSize(), pageQO.getPageNum(), total, hospitalList);
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
