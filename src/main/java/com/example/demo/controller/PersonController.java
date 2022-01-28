package com.example.demo.controller;

import com.example.demo.common.vo.R;
import com.example.demo.entity.Appointment;
import com.example.demo.entity.Person;
import com.example.demo.o.vo.ResultT;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "用户相关接口")
@Controller
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonService personService;

    @Resource
    private AppointmentService appointmentService;

    /**
     * 查询列表
     */
    @ApiOperation(value = "获取所有用户信息")
    @GetMapping("/list")
    @ResponseBody
    public R list() {
        List<Person> personList = personService.list(new Person());
        return R.ok().put(personList.size(), personList);
    }

    /**
     * 查询列表（通过RowBounds分页）
     */
    @ApiOperation(value = "获取用户信息（通过RowBounds分页）")
    @GetMapping("/pageListByRowBounds")
    @ResponseBody
    public R pageListByRowBounds(Person personQO,
                                 @ApiParam(name = "pageSize", value = "页大小", required = true, defaultValue = "3")
                                 @RequestParam(name = "pageSize")
                                         Integer pageSize,
                                 @ApiParam(name = "pageNum", value = "页码", required = true, defaultValue = "1")
                                 @RequestParam(name = "pageNum")
                                         Integer pageNum
    ) {
        return R.ok().put("result", personService.pageListByRowBounds(personQO, pageSize, pageNum));
    }

    /**
     * 查询列表
     */
    @ApiOperation(value = "获取特定用户信息", notes = "通过用户ID")
    @GetMapping("/get")
    @ResponseBody
    public R get(@ApiParam(name = "id", value = "用户ID", required = true, defaultValue = "3") @RequestParam(name = "id") Long userId) {
        return R.ok().put("result", personService.getById(userId));
    }

    /**
     * 获取已预约列表
     */
    @ApiOperation(value = "获取特定用户已预约列表", notes = "通过用户ID")
    @GetMapping("/getMyAppointment")
    @ResponseBody
    public R getMyAppointment(@ApiParam(name = "id", value = "用户ID", required = true, defaultValue = "3") @RequestParam(name = "id") Long userId) {
        Appointment appointmentQO = new Appointment();
        appointmentQO.setUserId(userId);
        List<Appointment> appointmentList = appointmentService.list(appointmentQO);
        ResultT<List<Appointment>> resultT0 = new ResultT<>(appointmentList);
        return R.ok().put("result", resultT0);
    }
}