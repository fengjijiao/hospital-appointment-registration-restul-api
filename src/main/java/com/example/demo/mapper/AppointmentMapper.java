package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.entity.Appointment;
import java.util.List;

@Mapper
public interface AppointmentMapper extends BaseMapper<Appointment> {

    @Select(
            "<script>select t0.* from appointment t0 " +
                    //add here if need left join
                    "where 1=1" +
                    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
                    "<when test='departmentId!=null and departmentId!=&apos;&apos; '> and t0.department_id=#{departmentId}</when> " +
                    "<when test='time!=null and time!=&apos;&apos; '> and t0.time=#{time}</when> " +
                    "<when test='userId!=null and userId!=&apos;&apos; '> and t0.user_id=#{userId}</when> " +
                    "<when test='status!=null and status!=&apos;&apos; '> and t0.status=#{status}</when> " +
                    "<when test='addTime!=null and addTime!=&apos;&apos; '> and t0.add_time=#{addTime}</when> " +
                    //add here if need page limit
                    //" limit ${page},${limit} " +
                    " </script>")
    List<Appointment> pageAll(Appointment queryParamDTO,int page,int limit);

    @Select("<script>select count(1) from appointment t0 " +
            //add here if need left join
            "where 1=1" +
            "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
            "<when test='departmentId!=null and departmentId!=&apos;&apos; '> and t0.department_id=#{departmentId}</when> " +
            "<when test='time!=null and time!=&apos;&apos; '> and t0.time=#{time}</when> " +
            "<when test='userId!=null and userId!=&apos;&apos; '> and t0.user_id=#{userId}</when> " +
            "<when test='status!=null and status!=&apos;&apos; '> and t0.status=#{status}</when> " +
            "<when test='addTime!=null and addTime!=&apos;&apos; '> and t0.add_time=#{addTime}</when> " +
            " </script>")
    int countAll(Appointment queryParamDTO);

}