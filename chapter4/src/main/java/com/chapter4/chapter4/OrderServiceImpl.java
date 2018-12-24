package com.chapter4.chapter4;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private OrderRepository orderRepository;

    public Order getByOrderNo(String orderNo) {

        return orderRepository.getByOrderNo(orderNo);
    }


    public void saveOrder(Order order) {
        orderRepository.save(order);

    }

    public Order getByOrderNoLike(String orderNo) {

        return orderRepository.getByOrderNoLike(orderNo);
    }

    public void removeOrderByOrderNo(String orderNo) {
        Query q = new Query(new Criteria("orderNo").is(orderNo));
        mongoTemplate.remove(q, Order.class);
    }

    public void updateOrder(Order order) {
        Query q = new Query(new Criteria("orderNo").is(order.getOrderNo()));
        Update update = new Update().set("nickName", order.getNickName());
        mongoTemplate.updateMulti(q, update, Order.class);
    }
}