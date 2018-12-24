package com.chapter4.chapter4;

public interface OrderService {
    public Order getByOrderNo(String orderNo);
    public Order getByOrderNoLike(String orderNo);
    public void saveOrder(Order order);
    public void removeOrderByOrderNo(String orderNo);
    public void updateOrder(Order order);
}
