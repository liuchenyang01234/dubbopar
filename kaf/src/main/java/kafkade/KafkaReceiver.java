package kafkade;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"user-log"},groupId = "xiaofeng1")
    public void listen(ConsumerRecord<?, ?> record) {
        String topic = record.topic();
        String value = (String)record.value();
        //  ConsumerRecord<String, String> record
        try {
            //System.out.println("kafka的key: " + record.key()+"kafka的value: " + record.value().toString());
            if(value != null){
                Object kafkaMessage = JSON.parseObject(value, Object.class);    //将kafka里的数据反序列化为实体
            }
        } catch (Exception e) {
            log.error("接收主题为"+topic+"的kafka的消息时异常, 消息:{}, 异常:{}", value, e);
            log.info("--消费者1--------------- record =" + record);
            log.info("----消费者1-------------- message =" + value);
        }

     //判断是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();

            log.info("--消费者1--------------- record =" + record);
            log.info("----消费者1-------------- message =" + message);
        }

    }
}
