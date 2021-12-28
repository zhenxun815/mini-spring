package com.yiheng;

import com.yiheng.starter.MiniApplication;

/**
 * @author Yiheng
 * @since 2021/12/20 20:59
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Application run!");

        MiniApplication.run(Application.class, args);
    }
}
