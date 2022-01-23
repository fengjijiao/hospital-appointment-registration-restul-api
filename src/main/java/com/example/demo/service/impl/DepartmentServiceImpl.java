package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service("departmentServiceImpl")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
