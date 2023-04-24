//package com.itheima.controller;
//
//import com.itheima.domain.Order;
//import com.itheima.service.impl.OrderServiceImpl5;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Slf4j
//public class OrderController5 {
//
//    @Autowired
//    private OrderServiceImpl5 orderService;
//
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        return orderService.createOrder(pid);
//    }
//
//}
