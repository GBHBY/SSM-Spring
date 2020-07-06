package com.gyb.proxy;

/**
 *
 */
public class Producer implements Iproducer {
    /**
     * 卖产品
     * @param money
     */
    @Override
    public void saleProduct(float money) {
        System.out.println("销售产品，拿到" + money + "元");

    }

    /**
     * 售后
     * @param money
     */
    @Override
    public void afterService(float money) {
        System.out.println("提供售后，拿到" + money + "元");

    }
}
