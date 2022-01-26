package com.example.demo.mapper;

import com.example.demo.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppointmentMapper {
    boolean save(Appointment queryParamDTO);

    boolean removeById(Long id);

    boolean remove(Appointment queryParamDTO);

    boolean update(Appointment queryParamDTO);

    List<Appointment> pageList(Appointment queryParamDTO, int page, int limit);

    List<Appointment> list(Appointment queryParamDTO);

    List<Appointment> validList(Long timestamp);

    Appointment getOne(Appointment queryParamDTO);

    Appointment getById(Long id);

    int countList(Appointment queryParamDTO);
}