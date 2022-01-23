package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.SchedulingStuff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchedulingStuffMapper extends BaseMapper<SchedulingStuff> {

    @Select(
            "<script>select t0.* from scheduling_stuff t0 " +
                    //add here if need left join
                    "where 1=1" +
                    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
                    "<when test='doctorId!=null and doctorId!=&apos;&apos; '> and t0.doctor_id=#{doctorId}</when> " +
                    "<when test='schedulingId!=null and schedulingId!=&apos;&apos; '> and t0.scheduling_id=#{schedulingId}</when> " +
                    "<when test='startTime!=null and startTime!=&apos;&apos; '> and t0.start_time=#{startTime}</when> " +
                    "<when test='endTime!=null and endTime!=&apos;&apos; '> and t0.end_time=#{endTime}</when> " +
                    "<when test='addTime!=null and addTime!=&apos;&apos; '> and t0.add_time=#{addTime}</when> " +
                    "<when test='departmentId!=null and departmentId!=&apos;&apos; '> and t0.department_id=#{departmentId}</when> " +
                    //add here if need page limit
                    //" limit ${page},${limit} " +
                    " </script>")
    List<SchedulingStuff> pageAll(SchedulingStuff queryParamDTO, int page, int limit);

    @Select("<script>select count(1) from scheduling_stuff t0 " +
            //add here if need left join
            "where 1=1" +
            "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
            "<when test='doctorId!=null and doctorId!=&apos;&apos; '> and t0.doctor_id=#{doctorId}</when> " +
            "<when test='schedulingId!=null and schedulingId!=&apos;&apos; '> and t0.scheduling_id=#{schedulingId}</when> " +
            "<when test='startTime!=null and startTime!=&apos;&apos; '> and t0.start_time=#{startTime}</when> " +
            "<when test='endTime!=null and endTime!=&apos;&apos; '> and t0.end_time=#{endTime}</when> " +
            "<when test='addTime!=null and addTime!=&apos;&apos; '> and t0.add_time=#{addTime}</when> " +
            "<when test='departmentId!=null and departmentId!=&apos;&apos; '> and t0.department_id=#{departmentId}</when> " +
            " </script>")
    int countAll(SchedulingStuff queryParamDTO);

}