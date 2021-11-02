package cn.edu.xmu.restfuldemo.service.mq;

import cn.edu.xmu.restfuldemo.bean.Post_Orders;
import cn.edu.xmu.restfuldemo.util.JacksonUtil;
//import org.apache.commons.text.StringEscapeUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "order-topic2", selectorExpression = "1", consumeMode = ConsumeMode.CONCURRENTLY, consumeThreadMax = 10, consumerGroup = "order2-group")
public class Order2ConsumerListener implements RocketMQListener<String>, RocketMQPushConsumerLifecycleListener {
    @Override
    public void onMessage(String message) {
        Post_Orders post_orders = JacksonUtil.toObj(message, Post_Orders.class);
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
    }
}
