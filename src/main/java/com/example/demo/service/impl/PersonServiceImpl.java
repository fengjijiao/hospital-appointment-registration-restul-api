package com.example.demo.service.impl;

import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.o.vo.PageVO;
import com.example.demo.service.PersonService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    @Override
    public boolean save(Person queryParamDTO) {
        return personMapper.save(queryParamDTO);
    }

    @Override
    public boolean removeById(Long id) {
        return personMapper.removeById(id);
    }

    @Override
    public boolean update(Person queryParamDTO) {
        return personMapper.save(queryParamDTO);
    }

    @Override
    public List<Person> pageList(Person queryParamDTO, int page, int limit) {
        return personMapper.pageList(queryParamDTO, page, limit);
    }

    @Override
    public PageVO<Person> pageListByRowBounds(Person queryParamDTO, int pageSize, int pageNum) {
        int total = personMapper.countList(queryParamDTO);
        List<Person> personList = personMapper.pageListByRowBounds(queryParamDTO, new RowBounds((pageNum - 1) * pageSize, pageSize));
        return new PageVO<>(pageSize, pageNum, total, personList);
    }

    @Override
    public List<Person> list(Person queryParamDTO) {
        return personMapper.list(queryParamDTO);
    }

    @Override
    public Person getOne(Person queryParamDTO) {
        return personMapper.getOne(queryParamDTO);
    }

    @Override
    public Person getById(Long id) {
        return personMapper.getById(id);
    }

    @Override
    public int countList(Person queryParamDTO) {
        return personMapper.countList(queryParamDTO);
    }
}
