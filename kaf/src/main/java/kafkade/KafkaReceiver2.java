package kafkade;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@Slf4j
public class KafkaReceiver2 {


    @KafkaListener(topics = {"user-log"},groupId = "xiaofeng2")
    public void listen(ConsumerRecord<?, ?> record) {
        //判断是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();

            log.info("消费者2-------- record =" + record);
            log.info("-消费者2----------- message =" + message);
        }

    }
}
