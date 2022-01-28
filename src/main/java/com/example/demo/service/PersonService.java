package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.o.vo.PageVO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {


    boolean save(Person queryParamDTO);

    boolean removeById(Long id);

    boolean update(Person queryParamDTO);

    List<Person> pageList(Person queryParamDTO, int page, int limit);

    PageVO<Person> pageListByRowBounds(Person queryParamDTO, int pageSize, int pageNum);

    List<Person> list(Person queryParamDTO);

    Person getOne(Person queryParamDTO);

    Person getById(Long id);

    int countList(Person queryParamDTO);

}