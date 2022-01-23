package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.entity.Doctor;
import java.util.List;

@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {

    @Select(
            "<script>select t0.* from doctor t0 " +
                    //add here if need left join
                    "where 1=1" +
                    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
                    "<when test='doctorName!=null and doctorName!=&apos;&apos; '> and t0.doctor_name=#{doctorName}</when> " +
                    "<when test='doctorSex!=null and doctorSex!=&apos;&apos; '> and t0.doctor_sex=#{doctorSex}</when> " +
                    "<when test='departmentId!=null and departmentId!=&apos;&apos; '> and t0.department_id=#{departmentId}</when> " +
                    "<when test='doctorJobTitle!=null and doctorJobTitle!=&apos;&apos; '> and t0.doctor_job_title=#{doctorJobTitle}</when> " +
                    //add here if need page limit
                    //" limit ${page},${limit} " +
                    " </script>")
    List<Doctor> pageAll(Doctor queryParamDTO,int page,int limit);

    @Select("<script>select count(1) from doctor t0 " +
            //add here if need left join
            "where 1=1" +
            "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
            "<when test='doctorName!=null and doctorName!=&apos;&apos; '> and t0.doctor_name=#{doctorName}</when> " +
            "<when test='doctorSex!=null and doctorSex!=&apos;&apos; '> and t0.doctor_sex=#{doctorSex}</when> " +
            "<when test='departmentId!=null and departmentId!=&apos;&apos; '> and t0.department_id=#{departmentId}</when> " +
            "<when test='doctorJobTitle!=null and doctorJobTitle!=&apos;&apos; '> and t0.doctor_job_title=#{doctorJobTitle}</when> " +
            " </script>")
    int countAll(Doctor queryParamDTO);

}