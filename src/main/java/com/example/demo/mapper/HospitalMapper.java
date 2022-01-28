package com.example.demo.mapper;

import com.example.demo.entity.Hospital;
import com.example.demo.o.qo.PageQO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface HospitalMapper {

    boolean save(Hospital queryParamDTO);

    boolean removeById(Long id);

    boolean update(Hospital queryParamDTO);

    List<Hospital> pageList(@Param("q") Hospital queryParamDTO, @Param("p") PageQO pageQO);

    List<Hospital> list(Hospital queryParamDTO);

    Hospital getOne(Hospital queryParamDTO);

    Hospital getById(Long id);

    int countList(Hospital queryParamDTO);

}