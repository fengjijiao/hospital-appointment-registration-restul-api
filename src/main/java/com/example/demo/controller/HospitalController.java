package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.vo.R;
import com.example.demo.entity.Hospital;
import com.example.demo.service.HospitalService;
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

@Api(tags = "医院相关接口")
@Controller
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @ApiOperation(value = "获取所有医院信息")
    @GetMapping("/list")
    @ResponseBody
    public R list() {
        List<Hospital> hospitalList = hospitalService.list();
        return R.ok().put(hospitalList.size(), hospitalList);
    }

    @ApiOperation(value = "获取特定医院信息", notes = "通过医院ID")
    @GetMapping("/get")
    @ResponseBody
    public R get(@ApiParam(name = "id", value = "医院ID", required = true, defaultValue = "1") @RequestParam(name = "id") Long hospitalId) {
        LambdaQueryWrapper<Hospital> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Hospital::getId, hospitalId);
        return R.ok().put("result", hospitalService.getOne(queryWrapper));
    }

    @ApiOperation(value = "获取子医院信息", notes = "通过总院ID")
    @GetMapping("/listSubHospital")
    @ResponseBody
    public R listSubHospital(@ApiParam(name = "id", value = "医院ID", required = true, defaultValue = "1") @RequestParam(name = "id") Long hospitalId) {
        LambdaQueryWrapper<Hospital> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Hospital::getHospitalParentId, hospitalId);
        List<Hospital> hospitalList = hospitalService.list(queryWrapper);
        return R.ok().put(hospitalList.size(), hospitalList);
    }
}