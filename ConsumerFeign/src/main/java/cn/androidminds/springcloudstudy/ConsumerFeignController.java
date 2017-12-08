package cn.androidminds.springcloudstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerFeignController {
    @Autowired
    ConsumerFeignService consumerFeignService;

    @RequestMapping("/")
    public @ResponseBody
    String sayHi(){
        return "ConsumerFeign : " + consumerFeignService.hiService();
    }
}
