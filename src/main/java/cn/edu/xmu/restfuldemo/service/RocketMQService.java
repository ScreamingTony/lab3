package cn.edu.xmu.restfuldemo.service;

import cn.edu.xmu.restfuldemo.bean.Post_Orders;
import cn.edu.xmu.restfuldemo.util.JacksonUtil;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RocketMQService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    //延时级别，没用到
    @Value("${rocketmqdemo.order-pay-topic.delay-level}")
    private int delayLevel;

    //超时时间，没用到
    @Value("${rocketmqdemo.order-pay-topic.timeout}")
    private long timeout;

    //单项发送
    public void sendOrdersMessage1(Post_Orders post_orders){
        String json=JacksonUtil.toJson(post_orders);
        Message message = MessageBuilder.withPayload(json).build();
        rocketMQTemplate.sendOneWay("order-topic1:1", message);
    }


    //异步发送，不知道有没有用，先写了
    public void sendOrderMessage2(Post_Orders post_orders){
        rocketMQTemplate.asyncSend("order-topic2", MessageBuilder.withPayload(post_orders.toString()).build(), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
               System.out.println("我超，成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("我超，寄了");
            }
        });
    }
}
