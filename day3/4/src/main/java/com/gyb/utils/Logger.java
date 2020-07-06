package com.gyb.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 记录日志
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置");
    }

    /**
     * 后置通知
     */
    public void afterPrintLog() {
        System.out.println("后置");
    }

    /**
     * 环绕通知
     */
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint) {
        Object object = null;
        try {
            //调用方法所需要的参数
            Object[] o = proceedingJoinPoint.getArgs();
//            写在proceed之前就是前置通知，写在proceed之后就是后置通知，写在catch就是异常，写在finally中就是最终
            System.out.println("环绕-前置");
            object = proceedingJoinPoint.proceed(o);
            int i = 1 / 0;
            System.out.println("环绕-后置");
        } catch (Throwable throwable) {
            System.out.println("环绕-异常");
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕-最终");
        }

        return object;
    }

    /**
     * 异常通知
     */
    public void exceptionPrintLog() {
        System.out.println("异常");
    }

    /**
     * 最终通知
     */
    public void finnalyPrintLog() {
        System.out.println("最终");
    }
}
