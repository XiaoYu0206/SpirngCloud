package com.xiaoyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单服务
 * @author xiaoyu
 */
@SpringBootApplication
@EnableEurekaClient  //开启eureka客户端
@EnableFeignClients //开启feign客户窜
@EnableHystrix //开启保护器：隔离，熔断，降级
public class AppOrder {

    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class,args);
    }
}
