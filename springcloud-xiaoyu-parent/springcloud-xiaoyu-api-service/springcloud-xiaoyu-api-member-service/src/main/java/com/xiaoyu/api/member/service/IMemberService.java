package com.xiaoyu.api.member.service;

import com.xiaoyu.api.member.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/member")
public interface IMemberService {

    /**
     * 该方法内部将延迟2秒用于雪崩效应测试
     * @param name
     * @return
     */
    @RequestMapping("/get")
    User getMember(@RequestParam("name") String name);

    /**
     * 内部无延迟，直接返回数据
     * @return
     */
    @RequestMapping("/getNormal")
    User getMemberNormal();

    /**
     * 被Hystrix保护的接口
     * @return
     */
    @RequestMapping("/getWithHystrix")
    User getMemberHystrix();



}
