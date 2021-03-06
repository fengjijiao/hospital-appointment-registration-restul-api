package com.example.demo.controller;

import com.example.demo.common.vo.R;
import com.example.demo.entity.Department;
import com.example.demo.o.vo.DepartmentItemVO;
import com.example.demo.o.vo.DepartmentTreeVO;
import com.example.demo.o.vo.ResultT;
import com.example.demo.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "科室相关接口")
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取科室信息（tree）
     *
     * @param hospitalId 医院ID
     * @return
     */
    @ApiOperation(value = "获取科室信息（tree）", notes = "通过医院ID")
    @GetMapping("/list")
    @ResponseBody
    public R list(
            @ApiParam(name = "id", value = "医院ID", required = true, defaultValue = "2")
            @RequestParam(name = "id")
                    Long hospitalId
    ) {
        Department queryParamDTO = new Department();
        queryParamDTO.setHospitalId(hospitalId);
        queryParamDTO.setParentId(0L);
        List<DepartmentItemVO> departmentItemVOList = new ArrayList<>();
        List<Department> fcDepartmentList = departmentService.list(queryParamDTO);
        fcDepartmentList.forEach(department -> {
            Department queryParamDTO1 = new Department();
            queryParamDTO1.setParentId(department.getId());
            List<Department> scDepartmentList = departmentService.list(queryParamDTO1);
            ResultT<List<Department>> resultT0 = new ResultT<>(scDepartmentList);
            DepartmentItemVO departmentItemVO = new DepartmentItemVO(resultT0);
            departmentItemVO.updateDepartmentInfo(department);
            departmentItemVOList.add(departmentItemVO);
        });
        DepartmentTreeVO departmentTreeVO = new DepartmentTreeVO(departmentItemVOList);
        return R.ok().put("result", departmentTreeVO);
    }

    /**
     * 获取一级科室信息
     *
     * @param hospitalId 医院ID
     * @return
     */
    @ApiOperation(value = "获取一级科室信息", notes = "通过医院ID")
    @GetMapping("/listFC")
    @ResponseBody
    public R listFC(@ApiParam(name = "id", value = "医院ID", required = true, defaultValue = "2") @RequestParam(name = "id") Long hospitalId) {
        Department queryParamDTO = new Department();
        queryParamDTO.setHospitalId(hospitalId);
        queryParamDTO.setParentId(0L);
        List<Department> departmentList = departmentService.list(queryParamDTO);
        return R.ok().put(departmentList.size(), departmentList);
    }

    /**
     * 获取二级科室信息
     *
     * @param fcId 一级科室ID
     * @return
     */
    @ApiOperation(value = "获取二级科室信息", notes = "通过一级科室ID")
    @GetMapping("/listSC")
    @ResponseBody
    public R listSC(@ApiParam(name = "id", value = "一级科室ID", required = true, defaultValue = "1") @RequestParam(name = "id") Long fcId) {
        Department queryParamDTO = new Department();
        queryParamDTO.setParentId(fcId);
        List<Department> departmentList = departmentService.list(queryParamDTO);
        return R.ok().put(departmentList.size(), departmentList);
    }

    /**
     * 获取特定科室信息
     *
     * @param departmentId 科室ID
     * @return
     */
    @ApiOperation(value = "获取特定科室信息", notes = "通过科室ID")
    @GetMapping("/get")
    @ResponseBody
    public R get(@ApiParam(name = "id", value = "科室ID", required = true, defaultValue = "3") @RequestParam(name = "id") Long departmentId) {
        return R.ok().put("result", departmentService.getById(departmentId));
    }
}