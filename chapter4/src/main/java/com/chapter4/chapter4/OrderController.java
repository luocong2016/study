package com.chapter4.chapter4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/saveOrder")
    @ResponseBody
    public String saveOrder() {

        Order order = new Order();
        order.setId(2);
        order.setNickName("潘玮柏");
        order.setOrderNo("X797468");
        order.setTotalPrice(4500.00);

        orderService.saveOrder(order);

        return "OK";
    }

    @RequestMapping("/getOrderByOrderNo")
    @ResponseBody
    public Order getOrderByOrderNo() {
        Order order = orderService.getByOrderNo("X797466");
        return order;
    }

    @RequestMapping("/getOrderByOrderNoLike")
    @ResponseBody
    public Order getOrderByOrderNoLike() {
        //String cond="X797";
        //Pattern pattern=Pattern.compile("^.*"++".*$");
        Order order = orderService.getByOrderNoLike("X797");
        return order;
    }

    @RequestMapping("/removeOrderByOrderNo")
    @ResponseBody
    public String removeOrderByOrderNo() {
        orderService.removeOrderByOrderNo("X797468");
        return "OK";
    }

    @RequestMapping("/updateOrder")
    @ResponseBody
    public String updateOrder() {
        Order order = new Order();
        order.setNickName("Justin Timberlake");
        order.setOrderNo("X797467");
        orderService.updateOrder(order);
        return "OK";
    }

}