package com.example.demo.mapper;

import com.example.demo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface PersonMapper {

    boolean save(Person queryParamDTO);

    boolean removeById(Long id);

    boolean update(Person queryParamDTO);

    List<Person> pageList(Person queryParamDTO, int page, int limit);

    List<Person> pageListByRowBounds(Person queryParamDTO, RowBounds rowBounds);//通过mybatis内置的RowBounds进行分页
    //此方法是将所有符合条件的数据加载到内存中，然后再用RowBounds进行分页，对内存压力很大，性能低。

    List<Person> list(Person queryParamDTO);

    Person getOne(Person queryParamDTO);

    Person getById(Long id);

    int countList(Person queryParamDTO);

}