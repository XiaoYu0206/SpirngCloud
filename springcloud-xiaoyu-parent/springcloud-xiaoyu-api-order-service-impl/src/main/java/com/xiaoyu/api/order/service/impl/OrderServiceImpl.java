package com.xiaoyu.api.order.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiaoyu.api.member.entity.User;
import com.xiaoyu.api.order.feign.MemberServiceFeign;
import com.xiaoyu.api.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @Override
    @RequestMapping("toMember")
    public String orderToMember(String name) {
        System.out.println("order/toMember接口接到请求，当前线程名称："+Thread.currentThread().getName());
        User user = memberServiceFeign.getMember(name);
        return  user == null?"没有找到用户信息":user.toString();
    }

    @Override
    @RequestMapping("toMemberNormal")
    public String orderToMemberNormal(){
        System.out.println("order/toMemberNormal接口接到请求，当前线程名称："+Thread.currentThread().getName());
        User user = memberServiceFeign.getMemberNormal();
        return user== null?"没有找到用户信息":user.toString();
    }

    @Override
    @RequestMapping("toMemberHystrix")
    @HystrixCommand(fallbackMethod = "fallBack") //默认开启服务隔离（线程池），服务降级，服务熔断机制
    public String orderToMemberHystrix() {
        System.out.println("order/toMemberHystrix接口接到请求，当前线程名称："+Thread.currentThread().getName());
        User user = memberServiceFeign.getMemberHystrix();
        return user== null?"没有找到用户信息":user.toString();
    }

    public String  fallBack(){
        return "服务器繁忙，请稍后重试";
    }
}
