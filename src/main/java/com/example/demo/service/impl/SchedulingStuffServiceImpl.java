package com.example.demo.service.impl;

import com.example.demo.entity.SchedulingStuff;
import com.example.demo.mapper.SchedulingStuffMapper;
import com.example.demo.service.SchedulingStuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("schedulingStuffServiceImpl")
public class SchedulingStuffServiceImpl implements SchedulingStuffService {
    @Autowired
    private SchedulingStuffMapper schedulingStuffMapper;

    @Override
    public boolean save(SchedulingStuff queryParamDTO) {
        return schedulingStuffMapper.save(queryParamDTO);
    }

    @Override
    public boolean removeById(Long id) {
        return schedulingStuffMapper.removeById(id);
    }

    @Override
    public boolean update(SchedulingStuff queryParamDTO) {
        return schedulingStuffMapper.save(queryParamDTO);
    }

    @Override
    public List<SchedulingStuff> pageList(SchedulingStuff queryParamDTO, int page, int limit) {
        return schedulingStuffMapper.pageList(queryParamDTO, page, limit);
    }

    @Override
    public List<SchedulingStuff> list(SchedulingStuff queryParamDTO) {
        return schedulingStuffMapper.list(queryParamDTO);
    }

    @Override
    public List<SchedulingStuff> validList(String date, String time) {
        return schedulingStuffMapper.validList(date, time);
    }

    @Override
    public SchedulingStuff getOne(SchedulingStuff queryParamDTO) {
        return schedulingStuffMapper.getOne(queryParamDTO);
    }

    @Override
    public SchedulingStuff getById(Long id) {
        return schedulingStuffMapper.getById(id);
    }

    @Override
    public int countList(SchedulingStuff queryParamDTO) {
        return schedulingStuffMapper.countList(queryParamDTO);
    }

    @Override
    public boolean clear() {
        return schedulingStuffMapper.clear();
    }
}
