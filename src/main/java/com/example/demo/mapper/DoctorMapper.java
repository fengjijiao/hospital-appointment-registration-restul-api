package com.example.demo.mapper;

import com.example.demo.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper {

    boolean save(Doctor queryParamDTO);

    boolean removeById(Long id);

    boolean update(Doctor queryParamDTO);

    List<Doctor> pageList(Doctor queryParamDTO, int page, int limit);

    List<Doctor> list(Doctor queryParamDTO);

    Doctor getOne(Doctor queryParamDTO);

    Doctor getById(Long id);

    int countList(Doctor queryParamDTO);

}