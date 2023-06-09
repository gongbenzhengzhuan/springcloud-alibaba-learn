package com.itheima.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/api1/demo1")
    public String demo1() {
        return "demo";
    }

    @RequestMapping("/product/api1/demo2")
    public String demo2() {
        return "demo";
    }

    @RequestMapping("/product/api2/demo1")
    public String demo3() {
        return "demo";
    }

    @RequestMapping("/product/api2/demo2")
    public String demo4() {
        return "demo";
    }


    //商品信息查询
    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        log.info("接下来要进行{}号商品信息的查询", pid);
        Product product = productService.findByPid(pid);
        log.info("商品信息查询成功,内容为{}", JSON.toJSONString(product));
        return product;
    }

    //扣减库存
    @RequestMapping("/product/reduceInventory")
    public void reduceInventory(Integer pid, Integer number) {
        productService.reduceInventory(pid, number);
    }
}
