package com.example.demo.service;

import com.example.demo.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    boolean save(Department queryParamDTO);

    boolean removeById(Long id);

    boolean update(Department queryParamDTO);

    List<Department> pageList(Department queryParamDTO, int page, int limit);

    List<Department> list(Department queryParamDTO);

    Department getOne(Department queryParamDTO);

    Department getById(Long id);

    int countList(Department queryParamDTO);
}