package cn.androidminds.springcloudstudy;

import org.springframework.stereotype.Component;

@Component
public class HiHystric implements ConsumerFeignService {
    @Override
    public String hiService() {
        return "Hi Service can not used!";
    }
}
