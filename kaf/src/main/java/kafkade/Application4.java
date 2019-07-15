package kafkade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ImportResource({ "classpath:*.xml" })
public class Application4{

    public static void main(String[] args) {
        SpringApplication.run(Application4.class, args);
    }

}
