package com.gyb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 消费者
 */
public class client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        producer.saleProduct(1000f);
        System.out.println("==============");
        Iproducer iproducer = (Iproducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何方法都会经过该方法，也就是说这个方法具有拦截功能
                     *
                     * @param proxy     代理对象的引用
                     * @param method    当前执行的方法
                     * @param args      当前执行方法所需的参数
                     * @return 和被代理对象有相同的返回值
                     * @throws Throwable
                     */

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue = null;
                        //1.获取方法执行的参数
                        Float money = (Float) args[0];
                        //2.判断当前方法是不是销售
                        if ("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8f);
                        }
                        return returnValue;
                    }
                });


        iproducer.saleProduct(1000f);
    }

}
