package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Service;

@Service("personServiceImpl")
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {
}
