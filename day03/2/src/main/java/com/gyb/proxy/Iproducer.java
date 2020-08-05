package com.gyb.proxy;

public interface Iproducer {

    /**
     * 卖产品
     *
     * @param money
     */
    void saleProduct(float money);

    /**
     * 售后
     *
     * @param money
     */
    void afterService(float money);
}
