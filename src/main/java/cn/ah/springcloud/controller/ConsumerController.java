package cn.ah.springcloud.controller;

import cn.ah.springcloud.model.User;
import cn.ah.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hui Zhang on 2017/12/29.
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value="/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }


    @GetMapping(value = "/feign-consumer2")
    public String helloConsumer2(){
        StringBuffer sb =new StringBuffer();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("didi")).append("\n");
        sb.append(helloService.hello("didi", 30)).append("\n");
        sb.append(helloService.hello(new User("username", 23))).append("\n");
        return sb.toString();
    }
}
