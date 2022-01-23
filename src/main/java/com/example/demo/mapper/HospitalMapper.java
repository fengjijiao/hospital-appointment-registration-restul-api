package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Hospital;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HospitalMapper extends BaseMapper<Hospital> {

    @Select(
            "<script>select t0.* from hospital t0 " +
                    //add here if need left join
                    "where 1=1" +
                    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
                    "<when test='hospitalName!=null and hospitalName!=&apos;&apos; '> and t0.hospital_name=#{hospitalName}</when> " +
                    "<when test='hospitalContact!=null and hospitalContact!=&apos;&apos; '> and t0.hospital_contact=#{hospitalContact}</when> " +
                    "<when test='hospitalLevel!=null and hospitalLevel!=&apos;&apos; '> and t0.hospital_level=#{hospitalLevel}</when> " +
                    "<when test='hospitalBranchType!=null and hospitalBranchType!=&apos;&apos; '> and t0.hospital_branch_type=#{hospitalBranchType}</when> " +
                    "<when test='hospitalIntroduction!=null and hospitalIntroduction!=&apos;&apos; '> and t0.hospital_introduction=#{hospitalIntroduction}</when> " +
                    "<when test='hospitalParentId!=null and hospitalParentId!=&apos;&apos; '> and t0.hospital_parent_id=#{hospitalParentId}</when> " +
                    //add here if need page limit
                    //" limit ${page},${limit} " +
                    " </script>")
    List<Hospital> pageAll(Hospital queryParamDTO, int page, int limit);

    @Select("<script>select count(1) from hospital t0 " +
            //add here if need left join
            "where 1=1" +
            "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
            "<when test='hospitalName!=null and hospitalName!=&apos;&apos; '> and t0.hospital_name=#{hospitalName}</when> " +
            "<when test='hospitalContact!=null and hospitalContact!=&apos;&apos; '> and t0.hospital_contact=#{hospitalContact}</when> " +
            "<when test='hospitalLevel!=null and hospitalLevel!=&apos;&apos; '> and t0.hospital_level=#{hospitalLevel}</when> " +
            "<when test='hospitalBranchType!=null and hospitalBranchType!=&apos;&apos; '> and t0.hospital_branch_type=#{hospitalBranchType}</when> " +
            "<when test='hospitalIntroduction!=null and hospitalIntroduction!=&apos;&apos; '> and t0.hospital_introduction=#{hospitalIntroduction}</when> " +
            "<when test='hospitalParentId!=null and hospitalParentId!=&apos;&apos; '> and t0.hospital_parent_id=#{hospitalParentId}</when> " +
            " </script>")
    int countAll(Hospital queryParamDTO);

}