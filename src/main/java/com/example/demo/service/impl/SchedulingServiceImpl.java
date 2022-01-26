package com.example.demo.service.impl;

import com.example.demo.entity.Scheduling;
import com.example.demo.mapper.SchedulingMapper;
import com.example.demo.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SchedulingServiceImpl implements SchedulingService {
    @Resource
    private SchedulingMapper schedulingMapper;

    @Override
    public boolean save(Scheduling queryParamDTO) {
        return schedulingMapper.save(queryParamDTO);
    }

    @Override
    public boolean removeById(Long id) {
        return schedulingMapper.removeById(id);
    }

    @Override
    public boolean update(Scheduling queryParamDTO) {
        return schedulingMapper.update(queryParamDTO);
    }

    @Override
    public List<Scheduling> pageList(Scheduling queryParamDTO, int page, int limit) {
        return schedulingMapper.pageList(queryParamDTO, page, limit);
    }

    @Override
    public List<Scheduling> list(Scheduling queryParamDTO) {
        return schedulingMapper.list(queryParamDTO);
    }

    @Override
    public List<Scheduling> validList(String dateStr) {
        return schedulingMapper.validList(dateStr);
    }

    @Override
    public Scheduling getOne(Scheduling queryParamDTO) {
        return schedulingMapper.getOne(queryParamDTO);
    }

    @Override
    public Scheduling getById(Long id) {
        return schedulingMapper.getById(id);
    }

    @Override
    public int countList(Scheduling queryParamDTO) {
        return schedulingMapper.countList(queryParamDTO);
    }
}
