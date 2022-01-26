package com.example.demo.mapper;

import com.example.demo.entity.Hospital;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalMapper {

    boolean save(Hospital queryParamDTO);

    boolean removeById(Long id);

    boolean update(Hospital queryParamDTO);

    List<Hospital> pageList(Hospital queryParamDTO, int page, int limit);

    List<Hospital> list(Hospital queryParamDTO);

    Hospital getOne(Hospital queryParamDTO);

    Hospital getById(Long id);

    int countList(Hospital queryParamDTO);

}