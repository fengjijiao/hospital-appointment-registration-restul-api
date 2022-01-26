package com.example.demo.controller;

import com.example.demo.common.vo.R;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
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

@Api(tags = "用户相关接口")
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

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
     * 查询列表
     */
    @ApiOperation(value = "获取特定用户信息", notes = "通过用户ID")
    @GetMapping("/get")
    @ResponseBody
    public R get(@ApiParam(name = "id", value = "用户ID", required = true, defaultValue = "3") @RequestParam(name = "id") Long userId) {
        return R.ok().put("result", personService.getById(userId));
    }
}