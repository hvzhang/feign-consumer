package cn.ah.springcloud.service;

import cn.ah.springcloud.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hui Zhang on 2017/12/29.
 */
@Component
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @GetMapping(value = "/hello1")
    String hello(@RequestParam("name") String name);

    @GetMapping(value = "/hello2")
    String hello(@RequestHeader("name") String name,
                 @RequestHeader("age") Integer age);

    @PostMapping(value = "/hello3")
    String hello(@RequestBody User user);

}
