package cn.androidminds.springcloudstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@FeignClient(value = "Hi")
public interface ConsumerFeignService {
    @RequestMapping(value = "/")
    String hiService();
}
