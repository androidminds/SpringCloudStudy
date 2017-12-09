package cn.androidminds.springcloudstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;

    @RequestMapping("/")
    public @ResponseBody
    String sayHi(){
        return "Consumer : " + consumerService.hiService();
    }

    @Value("${web.server.port}")
    String configPort;

    @RequestMapping("/config")
    public @ResponseBody
    String getConfig(){
        return "Consumer Config: " + configPort;
    }
}
