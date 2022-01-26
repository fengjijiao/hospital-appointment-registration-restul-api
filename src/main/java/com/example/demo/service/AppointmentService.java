package com.example.demo.service;

import com.example.demo.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {
    boolean save(Appointment queryParamDTO);

    boolean remove(Appointment queryParamDTO);

    boolean removeById(Long id);

    boolean update(Appointment queryParamDTO);

    List<Appointment> pageList(Appointment queryParamDTO, int page, int limit);

    List<Appointment> list(Appointment queryParamDTO);

    List<Appointment> validList(Long timestamp);

    Appointment getOne(Appointment queryParamDTO);

    Appointment getById(Long id);

    int countList(Appointment queryParamDTO);
}