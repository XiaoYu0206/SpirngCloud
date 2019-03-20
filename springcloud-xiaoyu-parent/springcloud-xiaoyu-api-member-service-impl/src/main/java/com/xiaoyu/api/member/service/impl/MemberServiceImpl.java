package com.xiaoyu.api.member.service.impl;

import com.xiaoyu.api.member.entity.User;
import com.xiaoyu.api.member.service.IMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberServiceImpl implements IMemberService {

    @Override
    @RequestMapping("get")
    public User getMember(@RequestParam("name") String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setName(name);
        user.setSex("男");
        return user;
    }

    @Override
    @RequestMapping("getNormal")
    public User getMemberNormal() {
        User user = new User();
        user.setName("getNormal");
        user.setSex("男");
        return user;
    }

    @Override
    @RequestMapping("/getWithHystrix")
    public User getMemberHystrix() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setName("getWithHystrix");
        user.setSex("男");
        return user;
    }
}
