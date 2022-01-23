package com.example.demo.constant;

import com.example.demo.utils.DateUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppointmentCache {
    public static class NoSources {
        private Long timestamp = 0L;
        private Integer dayOfMonth = 0;
        private Boolean checked = false;
        private Long parentId = 0L;

        public Boolean getChecked() {
            return checked;
        }

        public void setChecked(Boolean checked) {
            this.checked = checked;
        }

        public Long getParentId() {
            return parentId;
        }

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public Integer getDayOfMonth() {
            return dayOfMonth;
        }

        public void setDayOfMonth(Integer dayOfMonth) {
            this.dayOfMonth = dayOfMonth;
        }

        @Override
        public String toString() {
            return "NoSources{" +
                    "timestamp=" + timestamp +
                    ", dayOfMonth=" + dayOfMonth +
                    ", checked=" + checked +
                    ", parentId=" + parentId +
                    '}';
        }
    }

    //private static final Map<Long, List<Scheduling>> schedulingList = new HashMap<>();
    private static final Map<Long, Map<String, List<NoSources>>> noSourceList = new HashMap<>();
    private static final Lock nsl = new ReentrantLock();

//    public static List<Scheduling> listScheduling(Long doctorId) {
////        schedulingList.computeIfAbsent(doctorId, k -> new ArrayList<>());
//        return schedulingList.get(doctorId);
//    }

    public static Map<String, List<NoSources>> mapDoctorAllNS(Long doctorId) {
        noSourceList.computeIfAbsent(doctorId, k -> new HashMap<>());
        return noSourceList.get(doctorId);
    }

    public static List<NoSources> listNS(Long doctorId, String dateStr) {
        return noSourceList.get(doctorId).get(dateStr);
    }

    public static Boolean registerNoSource(Long doctorId, Long timestamp, Long parentId) {
        String dateStr = DateUtils.getDateStrFromTimestamp(timestamp);
        if (!noSourceList.containsKey(doctorId) || !noSourceList.get(doctorId).containsKey(dateStr)) return false;
        List<NoSources> nss = noSourceList.get(doctorId).get(dateStr);
        if (nss.stream().noneMatch(noSources -> timestamp.equals(noSources.getTimestamp()))) return false;
        NoSources ns = nss.stream().filter(noSources -> timestamp.equals(noSources.getTimestamp())).findFirst().orElse(null);
        if (ns == null || ns.checked) return false;
        nsl.lock();
        ns.checked = true;
        ns.parentId = parentId;
        nsl.unlock();
        return true;
    }

    public static Boolean unRegisterNoSource(Long doctorId, Long timestamp) {
        String dateStr = DateUtils.getDateStrFromTimestamp(timestamp);
        if (!noSourceList.containsKey(doctorId) || !noSourceList.get(doctorId).containsKey(dateStr)) return false;
        List<NoSources> nss = noSourceList.get(doctorId).get(dateStr);
        if (nss.stream().noneMatch(noSources -> timestamp.equals(noSources.getTimestamp()))) return false;
        NoSources ns = nss.stream().filter(noSources -> timestamp.equals(noSources.getTimestamp())).findFirst().orElse(null);
        if (ns == null || !ns.checked) return false;
        nsl.lock();
        ns.checked = false;
        ns.parentId = -1L;
        nsl.unlock();
        return true;
    }
}
