package com.example.demo.service;

import com.example.demo.entity.Hospital;
import com.example.demo.o.qo.PageQO;
import com.example.demo.o.vo.PageVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HospitalService {

    boolean save(Hospital queryParamDTO);

    boolean removeById(Long id);

    boolean update(Hospital queryParamDTO);

    PageVO<Hospital> pageList(Hospital queryParamDTO, PageQO pageQO);

    List<Hospital> list(Hospital queryParamDTO);

    Hospital getOne(Hospital queryParamDTO);

    Hospital getById(Long id);

    int countList(Hospital queryParamDTO);
}