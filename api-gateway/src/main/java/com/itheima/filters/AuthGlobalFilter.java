package com.itheima.filters;

import com.itheima.constant.AuthConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
// http://localhost:7000/product-serv/product/1?token=1
//自定义全局过滤器需要实现GlobalFilter和Ordered接口
// 这个要学习简单的前端，考虑前端能传什么参数给后端，前后端都能接受什么格式。
//@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    //完成判断逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        // 第一次登陆时，账号密码生成一个md5加密值，存到redis中，md5和用户编码对应
        // 每次访问，token值去和用户编码比对，如果有，就说明登陆过。然后拿用户编码去获取用户信息
        // 如果没有，让登陆。
        if (!StringUtils.equals(AuthConstant.auth.get(token), "admin")) {
            System.out.println("鉴权失败");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            // 跳转登陆页面
            return exchange.getResponse().setComplete();
        }
        //调用chain.filter继续向下游执行
        return chain.filter(exchange);
    }

    //顺序,数值越小,优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}