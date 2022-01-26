package com.example.demo.service.impl;

import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public boolean save(Department queryParamDTO) {
        return departmentMapper.save(queryParamDTO);
    }

    @Override
    public boolean removeById(Long id) {
        return departmentMapper.removeById(id);
    }

    @Override
    public boolean update(Department queryParamDTO) {
        return departmentMapper.update(queryParamDTO);
    }

    @Override
    public List<Department> pageList(Department queryParamDTO, int page, int limit) {
        return departmentMapper.pageList(queryParamDTO, page, limit);
    }

    @Override
    public List<Department> list(Department queryParamDTO) {
        return departmentMapper.list(queryParamDTO);
    }

    @Override
    public Department getOne(Department queryParamDTO) {
        return departmentMapper.getOne(queryParamDTO);
    }

    @Override
    public Department getById(Long id) {
        return departmentMapper.getById(id);
    }

    @Override
    public int countList(Department queryParamDTO) {
        return departmentMapper.countList(queryParamDTO);
    }
}
