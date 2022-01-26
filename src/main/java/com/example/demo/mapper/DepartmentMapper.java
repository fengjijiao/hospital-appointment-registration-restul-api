package com.example.demo.mapper;

import com.example.demo.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    boolean save(Department queryParamDTO);

    boolean removeById(Long id);

    boolean update(Department queryParamDTO);

    List<Department> pageList(Department queryParamDTO, int page, int limit);

    List<Department> list(Department queryParamDTO);

    Department getOne(Department queryParamDTO);

    Department getById(Long id);

    int countList(Department queryParamDTO);

}