package com.example.demo.service;

import com.example.demo.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {
    boolean save(Doctor queryParamDTO);

    boolean removeById(Long id);

    boolean update(Doctor queryParamDTO);

    List<Doctor> pageList(Doctor queryParamDTO, int page, int limit);

    List<Doctor> list(Doctor queryParamDTO);

    Doctor getOne(Doctor queryParamDTO);

    Doctor getById(Long id);

    int countList(Doctor queryParamDTO);
}