package com.example.demo.mapper;

import com.example.demo.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    boolean save(Person queryParamDTO);

    boolean removeById(Long id);

    boolean update(Person queryParamDTO);

    List<Person> pageList(Person queryParamDTO, int page, int limit);

    List<Person> list(Person queryParamDTO);

    Person getOne(Person queryParamDTO);

    Person getById(Long id);

    int countList(Person queryParamDTO);

}