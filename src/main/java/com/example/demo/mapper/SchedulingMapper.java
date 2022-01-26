package com.example.demo.mapper;

import com.example.demo.entity.Scheduling;

import java.util.List;

public interface SchedulingMapper {

    boolean save(Scheduling queryParamDTO);

    boolean removeById(Long id);

    boolean update(Scheduling queryParamDTO);

    List<Scheduling> pageList(Scheduling queryParamDTO, int page, int limit);

    List<Scheduling> list(Scheduling queryParamDTO);

    List<Scheduling> validList(String date);

    Scheduling getOne(Scheduling queryParamDTO);

    Scheduling getById(Long id);

    int countList(Scheduling queryParamDTO);

    boolean clear();

}