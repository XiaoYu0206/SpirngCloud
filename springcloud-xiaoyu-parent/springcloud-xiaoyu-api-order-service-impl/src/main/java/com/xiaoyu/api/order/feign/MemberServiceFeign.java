package com.xiaoyu.api.order.feign;

import com.xiaoyu.api.member.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 订单服务针对会员服务的Feign调用接口
 * @author xiaoyu
 */
@FeignClient("xiaoyu-eureka-client-member")
public interface MemberServiceFeign extends IMemberService {


}
