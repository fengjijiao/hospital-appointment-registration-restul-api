package com.example.demo.controller;

import com.example.demo.common.vo.R;
import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "医生相关接口")
@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @ApiOperation(value = "获取所有医生信息")
    @GetMapping("/list")
    @ResponseBody
    public R list() {
        List<Doctor> doctorList = doctorService.list(new Doctor());
        return R.ok().put(doctorList.size(), doctorList);
    }

    @ApiOperation(value = "获取特定医生信息", notes = "通过医生ID")
    @GetMapping("/get")
    @ResponseBody
    public R get(@ApiParam(name = "id", value = "医生ID", required = true, defaultValue = "3") @RequestParam(name = "id") Long doctorId) {
        return R.ok().put("result", doctorService.getById(doctorId));
    }

    @ApiOperation(value = "获取特定科室的所有医生信息", notes = "通过科室ID")
    @GetMapping("/listByDepartmentId")
    @ResponseBody
    public R listByDepartmentId(@ApiParam(name = "id", value = "科室ID", required = true, defaultValue = "3") @RequestParam(name = "id") Long departmentId) {
        Doctor doctorDTO = new Doctor();
        doctorDTO.setDepartmentId(departmentId);
        List<Doctor> doctorList = doctorService.list(doctorDTO);
        return R.ok().put(doctorList.size(), doctorList);
    }
}