package com.example.demo.service;

import com.example.demo.entity.Hospital;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HospitalService {

    boolean save(Hospital queryParamDTO);

    boolean removeById(Long id);

    boolean update(Hospital queryParamDTO);

    List<Hospital> pageList(Hospital queryParamDTO, int page, int limit);

    List<Hospital> list(Hospital queryParamDTO);

    Hospital getOne(Hospital queryParamDTO);

    Hospital getById(Long id);

    int countList(Hospital queryParamDTO);
}