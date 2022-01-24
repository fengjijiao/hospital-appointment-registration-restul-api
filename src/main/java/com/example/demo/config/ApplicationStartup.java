package com.example.demo.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.constant.AppointmentCache;
import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Scheduling;
import com.example.demo.entity.SchedulingStuff;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.SchedulingService;
import com.example.demo.service.SchedulingStuffService;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.TSUtils;
import com.example.demo.utils.TimeUtils;
import com.example.demo.utils.VTypeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Primary
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);

    @Autowired
    private SchedulingService schedulingService;

    @Autowired
    private SchedulingStuffService schedulingStuffService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    private static final long intervalValue = 600;
    private static final ChronoUnit intervalUnit = ChronoUnit.SECONDS;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("启动数据初始化：开始");
        genSchedulingStuffData();
        genNOSourceData();
        genRegisteredNOSourceData();
        logger.info("启动数据初始化：完成");
    }

    private void genSchedulingStuffData() {
        logger.info("生成排班计划：开始");
        LambdaQueryWrapper<Scheduling> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(Scheduling::getDate, DateUtils.getCurrentDate()).eq(Scheduling::getSchedulingStatus, 0).or(wrapper -> wrapper.eq(Scheduling::getDate, DateUtils.getCurrentDate()).eq(Scheduling::getSchedulingStatus, 0));//>= currentDate & status = 0
        List<Scheduling> schedulingList = schedulingService.list(queryWrapper);//获取排班计划
        schedulingStuffService.remove(new QueryWrapper<>());//清空排班医生表
        schedulingList.forEach(scheduling -> {
            LambdaQueryWrapper<Doctor> queryWrapper1 = new LambdaQueryWrapper<>();
            queryWrapper1.eq(Doctor::getDepartmentId, scheduling.getDepartmentId()).eq(Doctor::getDoctorStatus, 0);
            List<Doctor> doctorList = doctorService.list(queryWrapper1);//查出该科室的所有医生（状态正常）
            doctorList.forEach(doctor -> {
                SchedulingStuff ss = new SchedulingStuff();
                ss.setDepartmentId(scheduling.getDepartmentId());
                ss.setDoctorId(doctor.getId());
                ss.setSchedulingId(scheduling.getId());
                ss.setStartTime(scheduling.getStartTime());
                ss.setEndTime(scheduling.getEndTime());
                ss.setDate(scheduling.getDate());
                schedulingStuffService.save(ss);//将排班医生信息保存
            });
        });
        logger.info("生成排班计划：结束");
    }

    private void genNOSourceData() {
        logger.info("初始化号池：开始");
        LambdaQueryWrapper<SchedulingStuff> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(SchedulingStuff::getEndTime, TimeUtils.getCurrentTime()).eq(SchedulingStuff::getSchedulingStatus, 0)
                .or(wrapper -> wrapper.gt(SchedulingStuff::getDate, DateUtils.getCurrentDate()).eq(SchedulingStuff::getSchedulingStatus, 0));
        List<SchedulingStuff> schedulingStuffList = schedulingStuffService.list(queryWrapper);
        schedulingStuffList.forEach(schedulingStuff -> {
            LocalDateTime ldt = LocalDateTime.now();//当前时间
            LocalDateTime ldt1 = TimeUtils.mergeDateToLocalDateTimeViaInstant(schedulingStuff.getDate(), schedulingStuff.getEndTime());//结束时间LocalDateTime
            LocalDateTime ldt2 = TimeUtils.mergeDateToLocalDateTimeViaInstant(schedulingStuff.getDate(), schedulingStuff.getStartTime());//开始时间LocalDateTime
            if (ldt1.isBefore(ldt)) {//记录过期，删除该记录
                schedulingStuffService.removeById(schedulingStuff.getId());
            } else {//记录未过期，生成号源
                Map<String, List<AppointmentCache.NoSources>> doctorAppointments = AppointmentCache.mapDoctorAllNS(VTypeUtils.convertIntegerToLong(schedulingStuff.getDoctorId()));
                if (ldt2.isAfter(ldt)) {
                    ldt = ldt2;
                }
                ldt1 = ldt1.minus(intervalValue, intervalUnit);
                while (ldt1.isAfter(ldt)) {//时间有效
                    long timestamp1 = ldt1.toEpochSecond(ZoneOffset.of("+8"));
                    String date1 = DateUtils.getDateStrFromTimestamp(timestamp1);
                    List<AppointmentCache.NoSources> dateAppointments = doctorAppointments.computeIfAbsent(date1, k -> new ArrayList<>());
                    AppointmentCache.NoSources ns = new AppointmentCache.NoSources();
                    ns.setDayOfMonth(ldt1.getDayOfMonth());
                    ns.setTimestamp(timestamp1);
                    dateAppointments.add(ns);
                    ldt1 = ldt1.minus(intervalValue, intervalUnit);
                }
                System.out.println("记录：" + schedulingStuff.getId() + "生成完成！");
            }
        });
        logger.info("初始化号池：结束");
    }

    private void genRegisteredNOSourceData() {
        logger.info("初始化已预约号池：开始");
        LambdaQueryWrapper<Appointment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(Appointment::getTime, TSUtils.currentTimestamp());
        List<Appointment> appointmentList = appointmentService.list(queryWrapper);
        appointmentList.forEach(appointment -> AppointmentCache.registerNoSource(appointment.getDoctorId(), appointment.getTime(), appointment.getUserId()));
        logger.info("初始化已预约号池：结束");
    }
}
