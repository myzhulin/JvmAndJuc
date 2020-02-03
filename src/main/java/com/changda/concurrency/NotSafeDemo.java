package com.changda.concurrency;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: JucAndJvm
 * @classname: NotSafeDemo
 * @description: 请举例说明集合类是不安全的
 * 实现线程安全的几种方式
 * 1. new CopyOnWriteArrayList<>();
 * 2. new Vector<>();
 * 3. Collections.synchronizedList();
 * @author: 南街
 * @create: 2019-11-21 21:48
 **/
public class NotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
               list.add(UUID.randomUUID().toString().substring(0,8));
               System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
