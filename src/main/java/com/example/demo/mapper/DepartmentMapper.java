package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.entity.Department;
import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    @Select(
            "<script>select t0.* from department t0 " +
                    //add here if need left join
                    "where 1=1" +
                    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
                    "<when test='hospitalId!=null and hospitalId!=&apos;&apos; '> and t0.hospital_id=#{hospitalId}</when> " +
                    "<when test='departmentName!=null and departmentName!=&apos;&apos; '> and t0.department_name=#{departmentName}</when> " +
                    "<when test='parentId!=null and parentId!=&apos;&apos; '> and t0.parent_id=#{parentId}</when> " +
                    //add here if need page limit
                    //" limit ${page},${limit} " +
                    " </script>")
    List<Department> pageAll(Department queryParamDTO,int page,int limit);

    @Select("<script>select count(1) from department t0 " +
            //add here if need left join
            "where 1=1" +
            "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
            "<when test='hospitalId!=null and hospitalId!=&apos;&apos; '> and t0.hospital_id=#{hospitalId}</when> " +
            "<when test='departmentName!=null and departmentName!=&apos;&apos; '> and t0.department_name=#{departmentName}</when> " +
            "<when test='parentId!=null and parentId!=&apos;&apos; '> and t0.parent_id=#{parentId}</when> " +
            " </script>")
    int countAll(Department queryParamDTO);

}