package com.example.demo.service;

import com.example.demo.entity.Scheduling;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface SchedulingService {
    boolean save(Scheduling queryParamDTO);

    boolean removeById(Long id);

    boolean update(Scheduling queryParamDTO);

    List<Scheduling> pageList(Scheduling queryParamDTO, int page, int limit);

    List<Scheduling> list(Scheduling queryParamDTO);

    List<Scheduling> validList(String dateStr);

    Scheduling getOne(Scheduling queryParamDTO);

    Scheduling getById(Long id);

    int countList(Scheduling queryParamDTO);
}