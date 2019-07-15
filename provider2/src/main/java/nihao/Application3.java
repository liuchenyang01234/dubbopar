package nihao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:*.xml" })
public class Application3 {

    public static void main(String[] args) {
        SpringApplication.run(Application3.class, args);
    }

}
