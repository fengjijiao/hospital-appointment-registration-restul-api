package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.vo.R;
import com.example.demo.constant.AppointmentCache;
import com.example.demo.constant.DefaultConstant;
import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.DoctorService;
import com.example.demo.utils.TimeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "预约相关接口")
@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AppointmentService appointmentService;

    /**
     * 获取可预约列表
     * 参数：
     * did：医生ID
     */
    @ApiOperation(value = "查询可预约时间列表", notes = "根据医生id查询")
    @GetMapping("/list")
    @ResponseBody
    public R list(@ApiParam(name = "id", value = "医生ID", required = true, defaultValue = "3") @RequestParam(name = "id") Long doctorId) {
        Map<String, List<AppointmentCache.NoSources>> data = AppointmentCache.mapDoctorAllNS(doctorId);
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        List<Map.Entry<String, List<AppointmentCache.NoSources>>> dataSet = new ArrayList<>(data.entrySet());
        dataSet.sort(Map.Entry.comparingByKey());
        data.forEach((key, value) -> value.sort((o1, o2) -> (int) (o1.getTimestamp() - o2.getTimestamp())));
        long currentTS = System.currentTimeMillis() / 1000;
        dataSet.forEach(integerListEntry -> {
            JSONArray jsonArray = new JSONArray();
            integerListEntry.getValue().forEach(ns -> {
                if (currentTS < ns.getTimestamp()) {
                    LocalDateTime ldt = LocalDateTime.ofEpochSecond(ns.getTimestamp(), 0, ZoneOffset.of("+8"));
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("time", ns.getTimestamp());
                    jsonObject1.put("time1", TimeUtils.getTimeStrFromTimestamp(ns.getTimestamp() * 1000));
                    jsonObject1.put("checked", ns.getChecked());
                    jsonObject1.put("checked1", ns.getChecked() ? "已被预约" : "未被预约");
                    jsonObject1.put("dayOfWeek", ldt.getDayOfWeek().getValue());
                    jsonObject1.put("dayOfWeek1", DefaultConstant.dayOfWeeks[ldt.getDayOfWeek().getValue()]);
                    jsonArray.add(jsonObject1);
                } else {
                    integerListEntry.getValue().remove(ns);
                }
            });
            if (integerListEntry.getValue().size() > 0) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("length", integerListEntry.getValue().size());
                jsonObject1.put("data", jsonArray);
                jsonObject.put(integerListEntry.getKey(), jsonObject1);
            }
        });
        return R.ok().put("result", jsonObject);
    }

    /**
     * 预约
     * 参数：
     * uid: 用户ID
     * did: 医生ID
     * time: 预约时间
     */
    @ApiOperation(value = "预约时间", notes = "根据医生id&用户id&时间进行预约")
    @GetMapping("/register")
    @ResponseBody
    public R register(@ApiParam(name = "uid", value = "用户ID", required = true, defaultValue = "3") @RequestParam(name = "uid") Long userId,
                      @ApiParam(name = "did", value = "医生ID", required = true, defaultValue = "3") @RequestParam(name = "did") Long doctorId,
                      @ApiParam(name = "time", value = "时间/s", required = true, defaultValue = "1643185800") @RequestParam(name = "time") Long time) {
        LocalDateTime ldt = LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.of("+8"));
        Doctor doctor = doctorService.getById(doctorId);
        if (doctor == null) {
            return R.error(40002, "该医生不存在！");
        }
        boolean result = AppointmentCache.registerNoSource(doctorId, time, userId);
        if (result) {
            Appointment appointment = new Appointment();
            appointment.setDepartmentId(doctor.getDepartmentId());
            appointment.setDoctorId(doctor.getId());
            appointment.setUserId(userId);
            appointment.setTime(time);
            boolean result1 = appointmentService.save(appointment);
            return R.ok().put("result", result1);
        } else {
            return R.ok().put("result", false);
        }
    }

    /**
     * 退号
     * 参数：
     * Uid: 用户ID
     * Did: 医生ID
     * time: 预约时间
     */
    @ApiOperation(value = "取消预约时间", notes = "根据医生id&用户id&时间进行取消预约")
    @GetMapping("/unregister")
    @ResponseBody
    public R unRegister(@ApiParam(name = "uid", value = "用户ID", required = true, defaultValue = "3") @RequestParam(name = "uid") Long userId,
                        @ApiParam(name = "did", value = "医生ID", required = true, defaultValue = "3") @RequestParam(name = "did") Long doctorId,
                        @ApiParam(name = "time", value = "时间/s", required = true, defaultValue = "1643185800") @RequestParam(name = "time") Long time) {
        LocalDateTime ldt = LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.of("+8"));
        Doctor doctor = doctorService.getById(doctorId);
        if (doctor == null) {
            return R.error(40002, "该医生不存在！");
        }
        boolean result = AppointmentCache.unRegisterNoSource(doctorId, time);
        if (result) {
            Appointment appointment = new Appointment();
            appointment.setUserId(userId)
                    .setTime(time)
                    .setDoctorId(doctorId);
            boolean result1 = appointmentService.remove(appointment);
            return R.ok().put("result", result1);
        } else {
            return R.ok().put("result", false);
        }
    }
}
