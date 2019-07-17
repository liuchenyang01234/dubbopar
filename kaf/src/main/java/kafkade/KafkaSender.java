package kafkade;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 发送数据
     * @param userid
     */
    public void sendLog(String userid){
        UserLog userLog = new UserLog();
        userLog.setUsername("刘晨阳").setUserid(userid).setState("0");
        System.err.println("发送用户日志数据:"+userLog);
        //会创造一个主题
        kafkaTemplate.send("user-log", JSON.toJSONString(userLog));
        System.out.println("异步");

    }

}