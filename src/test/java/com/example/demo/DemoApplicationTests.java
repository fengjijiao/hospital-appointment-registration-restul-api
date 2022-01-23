package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {
    private static final ExecutorService pool = new ThreadPoolExecutor(2, 9, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(6));

    @Test
    void contextLoads() {
        //
    }

    public static class MyRun implements Runnable {

        @Override
        public void run() {
//            System.out.println(Thread.currentThread().getName() + "：：" + DefaultData.checkedNoSource(1L, DefaultData.getNoSources(1L).get(25).get(2).getTimestamp(), 1L));
//            System.out.println(Thread.currentThread().getName() + "：：" + DefaultData.checkedNoSource(1L, DefaultData.getNoSources(1L).get(25).get(2).getTimestamp(), 1L));
//            System.out.println(Thread.currentThread().getName() + "：：" + DefaultData.unCheckedNoSource(1L, DefaultData.getNoSources(1L).get(25).get(2).getTimestamp(), 1L));
//            System.out.println(Thread.currentThread().getName() + "：：" + DefaultData.checkedNoSource(1L, DefaultData.getNoSources(1L).get(25).get(2).getTimestamp(), 1L));
        }
    }

}
