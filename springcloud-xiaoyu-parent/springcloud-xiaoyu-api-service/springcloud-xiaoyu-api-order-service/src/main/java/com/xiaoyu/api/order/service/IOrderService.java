package com.xiaoyu.api.order.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单服务抽象接口
 * @author xiaoyu
 *
 */
@RequestMapping("order")
public interface IOrderService {

    /**
     * 调用会员的普通带延迟的接口
     * @param name
     * @return
     */
    //订单服务调用会员服务接口
    @RequestMapping("toMember")
    String orderToMember(String name);

    /**
     * 调用会员的无延迟接口
     * @return
     */
    @RequestMapping("toMemberNormal")
    String orderToMemberNormal();

    /**
     * 调用会员的受Hystrix保护的接口
     * @return
     */
    @RequestMapping("toMemberHystrix")
    String orderToMemberHystrix();
}
