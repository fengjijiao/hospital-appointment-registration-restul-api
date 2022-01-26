package com.example.demo.service;

import com.example.demo.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {


    boolean save(Person queryParamDTO);

    boolean removeById(Long id);

    boolean update(Person queryParamDTO);

    List<Person> pageList(Person queryParamDTO, int page, int limit);

    List<Person> list(Person queryParamDTO);

    Person getOne(Person queryParamDTO);

    Person getById(Long id);

    int countList(Person queryParamDTO);

}