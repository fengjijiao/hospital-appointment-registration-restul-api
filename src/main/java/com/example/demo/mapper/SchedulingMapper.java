package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Scheduling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchedulingMapper extends BaseMapper<Scheduling> {

    @Select(
            "<script>select t0.* from scheduling t0 " +
                    //add here if need left join
                    "where 1=1" +
                    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
                    "<when test='departmentId!=null and departmentId!=&apos;&apos; '> and t0.department_id=#{departmentId}</when> " +
                    "<when test='date!=null and date!=&apos;&apos; '> and t0.date=#{date}</when> " +
                    "<when test='startTime!=null and startTime!=&apos;&apos; '> and t0.start_time=#{startTime}</when> " +
                    "<when test='endTime!=null and endTime!=&apos;&apos; '> and t0.end_time=#{endTime}</when> " +
                    "<when test='addTime!=null and addTime!=&apos;&apos; '> and t0.add_time=#{addTime}</when> " +
                    //add here if need page limit
                    //" limit ${page},${limit} " +
                    " </script>")
    List<Scheduling> pageAll(Scheduling queryParamDTO, int page, int limit);

    @Select("<script>select count(1) from scheduling t0 " +
            //add here if need left join
            "where 1=1" +
            "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
            "<when test='departmentId!=null and departmentId!=&apos;&apos; '> and t0.department_id=#{departmentId}</when> " +
            "<when test='date!=null and date!=&apos;&apos; '> and t0.date=#{date}</when> " +
            "<when test='startTime!=null and startTime!=&apos;&apos; '> and t0.start_time=#{startTime}</when> " +
            "<when test='endTime!=null and endTime!=&apos;&apos; '> and t0.end_time=#{endTime}</when> " +
            "<when test='addTime!=null and addTime!=&apos;&apos; '> and t0.add_time=#{addTime}</when> " +
            " </script>")
    int countAll(Scheduling queryParamDTO);

}