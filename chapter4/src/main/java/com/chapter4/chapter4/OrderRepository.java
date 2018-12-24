package com.chapter4.chapter4;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Integer> {
    Order getByOrderNo(String orderNo);

    public Order getByOrderNoLike(String orderNo);
}