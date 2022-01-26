package com.example.demo.service;

import com.example.demo.entity.SchedulingStuff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchedulingStuffService {
    boolean save(SchedulingStuff queryParamDTO);

    boolean removeById(Long id);

    boolean update(SchedulingStuff queryParamDTO);

    List<SchedulingStuff> pageList(SchedulingStuff queryParamDTO, int page, int limit);

    List<SchedulingStuff> list(SchedulingStuff queryParamDTO);

    List<SchedulingStuff> validList(String date, String time);

    SchedulingStuff getOne(SchedulingStuff queryParamDTO);

    SchedulingStuff getById(Long id);

    int countList(SchedulingStuff queryParamDTO);

    boolean clear();
}