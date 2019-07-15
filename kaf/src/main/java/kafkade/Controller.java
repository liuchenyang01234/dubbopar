package kafkade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private KafkaSender  kafkaSender;

    @RequestMapping("/hello")
    public String name()
    {
        kafkaSender.sendLog(String.valueOf(1));
     return "hello";

    }

}
