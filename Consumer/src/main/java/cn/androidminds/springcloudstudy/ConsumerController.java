package cn.androidminds.springcloudstudy;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@RestController
@RefreshScope
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;

    @PostConstruct
    void init() {

    }

    @RequestMapping("/")
    public @ResponseBody
    String sayHi() {

        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            return "Consumer : " + consumerService.hiService() + ":" + consumerService.hiService() + ":" + request.getHeader("test");
        } finally {
            context.shutdown();
        }
    }
}
