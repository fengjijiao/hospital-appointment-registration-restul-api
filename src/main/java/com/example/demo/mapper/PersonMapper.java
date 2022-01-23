package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.entity.Person;
import java.util.List;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {

    @Select(
            "<script>select t0.* from person t0 " +
                    //add here if need left join
                    "where 1=1" +
                    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
                    "<when test='username!=null and username!=&apos;&apos; '> and t0.username=#{username}</when> " +
                    "<when test='userage!=null and userage!=&apos;&apos; '> and t0.userage=#{userage}</when> " +
                    "<when test='mobile!=null and mobile!=&apos;&apos; '> and t0.mobile=#{mobile}</when> " +
                    "<when test='sex!=null and sex!=&apos;&apos; '> and t0.sex=#{sex}</when> " +
                    "<when test='idcardno!=null and idcardno!=&apos;&apos; '> and t0.idcardno=#{idcardno}</when> " +
                    //add here if need page limit
                    //" limit ${page},${limit} " +
                    " </script>")
    List<Person> pageAll(Person queryParamDTO,int page,int limit);

    @Select("<script>select count(1) from person t0 " +
            //add here if need left join
            "where 1=1" +
            "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
            "<when test='username!=null and username!=&apos;&apos; '> and t0.username=#{username}</when> " +
            "<when test='userage!=null and userage!=&apos;&apos; '> and t0.userage=#{userage}</when> " +
            "<when test='mobile!=null and mobile!=&apos;&apos; '> and t0.mobile=#{mobile}</when> " +
            "<when test='sex!=null and sex!=&apos;&apos; '> and t0.sex=#{sex}</when> " +
            "<when test='idcardno!=null and idcardno!=&apos;&apos; '> and t0.idcardno=#{idcardno}</when> " +
            " </script>")
    int countAll(Person queryParamDTO);

}