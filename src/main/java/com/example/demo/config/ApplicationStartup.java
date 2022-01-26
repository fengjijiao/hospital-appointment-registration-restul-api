package com.example.demo.config;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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

    @Resource
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
        logger.info("Startup data initialization: start");
        genSchedulingStuffData();
        genNOSourceData();
        genRegisteredNOSourceData();
        logger.info("Startup data initialization: done");
    }

    private void genSchedulingStuffData() {
        logger.info("Generate Shift Schedule: start");
        List<Scheduling> schedulingList = schedulingService.validList(DateUtils.getCurrentDateStr());
        schedulingStuffService.clear();
        schedulingList.forEach(scheduling -> {
            Doctor doctorDTO = new Doctor();
            doctorDTO
                    .setDepartmentId(scheduling.getDepartmentId())
                    .setDoctorStatus(0);
            List<Doctor> doctorList = doctorService.list(doctorDTO);
            doctorList.forEach(doctor -> {
                SchedulingStuff schedulingStuffDTO = new SchedulingStuff();
                schedulingStuffDTO.setDepartmentId(scheduling.getDepartmentId());
                schedulingStuffDTO.setDoctorId(doctor.getId());
                schedulingStuffDTO.setSchedulingId(scheduling.getId());
                schedulingStuffDTO.setStartTime(scheduling.getStartTime());
                schedulingStuffDTO.setEndTime(scheduling.getEndTime());
                schedulingStuffDTO.setDate(scheduling.getDate());
                schedulingStuffService.save(schedulingStuffDTO);
            });
        });
        logger.info("Generate Shift Schedule: end");
    }

    private void genNOSourceData() {
        logger.info("Initialization pool: start");
        List<SchedulingStuff> schedulingStuffList = schedulingStuffService
                .validList(DateUtils.getCurrentDateStr(), TimeUtils.getCurrentTimeStr());
        schedulingStuffList.forEach(schedulingStuff -> {
            LocalDateTime ldt = LocalDateTime.now();
            LocalDateTime ldt1 = TimeUtils.mergeDateToLocalDateTimeViaInstant(schedulingStuff.getDate(), schedulingStuff.getEndTime());
            LocalDateTime ldt2 = TimeUtils.mergeDateToLocalDateTimeViaInstant(schedulingStuff.getDate(), schedulingStuff.getStartTime());
            if (ldt1.isBefore(ldt)) {
                schedulingStuffService.removeById(schedulingStuff.getId());
            } else {
                Map<String, List<AppointmentCache.NoSources>> doctorAppointments = AppointmentCache
                        .mapDoctorAllNS(schedulingStuff.getDoctorId());
                if (ldt2.isAfter(ldt)) {
                    ldt = ldt2;
                }
                ldt1 = ldt1.minus(intervalValue, intervalUnit);
                while (ldt1.isAfter(ldt)) {
                    long timestamp1 = ldt1.toEpochSecond(ZoneOffset.of("+8"));
                    String date1 = DateUtils.getDateStrFromTimestamp(timestamp1);
                    List<AppointmentCache.NoSources> dateAppointments = doctorAppointments.computeIfAbsent(date1, k -> new ArrayList<>());
                    AppointmentCache.NoSources ns = new AppointmentCache.NoSources();
                    ns.setDayOfMonth(ldt1.getDayOfMonth());
                    ns.setTimestamp(timestamp1);
                    dateAppointments.add(ns);
                    ldt1 = ldt1.minus(intervalValue, intervalUnit);
                }
                logger.info("Record:" + schedulingStuff.getId() + "Generation complete!");
            }
        });
        logger.info("Initialization pool: end");
    }

    private void genRegisteredNOSourceData() {
        logger.info("Initialize reserved number pool: start");
        List<Appointment> appointmentList = appointmentService.validList(TSUtils.currentTimestamp());
        appointmentList.forEach(appointment -> AppointmentCache.registerNoSource(appointment.getDoctorId(), appointment.getTime(), appointment.getUserId()));
        logger.info("Initialize reserved number pool: end");
    }
}