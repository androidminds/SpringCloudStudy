package cn.androidminds.springcloudstudy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "Hi",fallback = HiHystric.class)
public interface ConsumerFeignService {
    @RequestMapping(value = "/")
    String hiService();
}
